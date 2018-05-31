package leetcode.ch1;

/**
 * 162. 寻找峰值
 */
public class S162 {

    public int findPeakElement(int[] nums) {

        return handle3(nums);
    }

    /**
     * O(N)复杂度
     * @param nums
     * @return
     */
    public int handle(int[] nums){
        if (nums.length == 1)
            return 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        return 0;
    }

    /**
     * 如果找到第一个这样的数，它比前面的数小，则它前面的数，必定为峰值
     * 否则这个数组为递增数组，那么返回最后一个
     * 复杂度为O（N）
     * @param nums
     * @return
     */
    public int handle2(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1])
                return i-1;
        }

        return nums.length-1;
    }

    /**
     * 二分查找实现
     * @param nums
     * @return
     */
    public int handle3(int[] nums){
        int left = 0,right = nums.length-1;
        int mid;
        while (left < right){
            mid = (left + right ) / 2;
            if (nums[mid] < nums[mid+1]){
                left = mid+1;
                continue;
            }
            if (nums[mid] > nums[mid+1]){
                right = mid;
                continue;
            }
        }
        mid = (left + right) /2;
        return mid;
    }
}



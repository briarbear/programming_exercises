package leetcode.ch3;

/**
 * 33 搜索旋转排序数组
 */

public class S33 {


    public int search(int[] nums, int target) {
        //二分查找
        if (nums.length == 0)
            return -1;
        int start = 0,end = nums.length-1;
        int mid,res = -1;

        while (start<=end){
            mid = (start+end)/2;

            if (nums[mid] == target)
                return mid;
            if (nums[mid] > nums[end]){
                //如果中间值大于最右边的值，则左侧有序
                if (nums[start] <= target && target<= nums[mid] )
                    end = mid-1;
                else
                    start = mid+1;
            }else {
                //如果中间值小于右侧值，，则右侧有序
                if (nums[mid] <= target && target <= nums[end])
                    start = mid +1;
                else
                    end = mid -1;
            }


        }

        return res;
    }





}

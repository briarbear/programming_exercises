package leetcode.ch3;

/**
 * 34. 搜索范围
 */
public class S34 {

    public int[] searchRange(int[] nums, int target) {
        //二分查找
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        boolean flag = false;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                flag = true;
                break;
            }
        }
        int[] res = new int[]{-1, -1};
        if (!flag)
            return res;
        int start = mid, end = mid;

        for (; start >= 0 && nums[start] == target; start--);
        for (; end < nums.length && nums[end] == target; end++);
        res[0] = start+1;
        res[1] = end-1;
        return res;
    }
}

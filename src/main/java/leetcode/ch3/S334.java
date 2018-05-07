package leetcode.ch3;

/**
 * 334 递增的子序列
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-07-20:50
 */
public class S334 {

    /**
     * 暴力搜索
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int count = 0;
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < len; k++) {
                        if (nums[k] > nums[j])
                            return true;
                    }
                }
            }
        }
        return false;

    }
}

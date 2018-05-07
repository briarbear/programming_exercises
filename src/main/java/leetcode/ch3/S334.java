package leetcode.ch3;

/**
 * 334 递增的子序列
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-07-20:50
 */
public class S334 {

    public boolean increasingTriplet(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len-2; i++) {
            int count = 0;
            for (int j = 1; j < len; j++) {
                if (nums[j] > nums[i])
                    count++;
                if (count==2)
                    return true;
            }
        }
        return false;

    }
}

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
     *
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

    /**
     * 动态规划 dp[i]表示第i个位置的数之前比它小的数的个数，不包括自身
     * 如果dp[i]>=2 则返回true
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] == 2)
                    return true;
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return false;
    }

    /**
     * 这个思路是使用两个指针p1和p2，初始化为整型最大值，我们遍历数组，如果m1大于等于当前数字，则将当前数字赋给p1；
     * 如果m1小于当前数字且p2大于等于当前数字，那么将当前数字赋给p2，
     * 一旦m2被更新了，说明一定会有一个数小于p2，那么我们就成功的组成了一个长度为2的递增子序列，
     * 所以我们一旦遍历到比p2还大的数，我们直接返回ture。如果我们遇到比p1小的数，还是要更新p1，
     * 有可能的话也要更新p2为更小的值，毕竟p2的值越小，能组成长度为3的递增序列的可能性越大
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet3(int[] nums) {
        int p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
        //p1总是找到从i起最小的数，p2总是找到从i起比p1大的数中最小的那个
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];

            if (temp > p2)  //如果找到一个比p2大的数，则直接返回true，因为p2从最大的数变过来，说明p2之前已经可以组成长度为2的序列
                return true;
            if (temp <= p1)  //如果找到比p1小，则替换p1
                p1 = temp;
            else if (temp <= p2)  //找到比p1大，且小于等于p2.则替换p2
                p2 = temp;
        }

        return false;
    }

    /**
     * 这种方法的虽然不满足常数空间的要求，但是作为对暴力搜索的优化，也是一种非常好的解题思路。
     * 这个解法的思路是建立两个数组，forward数组和backward数组，其中forward[i]表示[0, i]之间最小的数，backward[i]表示[i, n-1]之间最大的数，
     * 那么对于任意一个位置i，如果满足 forward[i] < nums[i] < backward[i]，则表示这个递增三元子序列存在
     */
    public boolean increasingTriplet4(int[] nums){
        int len = nums.length;
        if (len<3)
            return false;

        int[] f = new int[len];
        int[] b = new int[len];
        //1. 得到f数组,从左到右
        f[0]=nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i]<f[i-1])
                f[i] = nums[i];
            else f[i] = f[i-1];
        }
        //2 得到b数组 从右到左
        b[len-1] = nums[len-1];
        for (int i = len-2; i >=0 ; i--) {
            if (nums[i]>b[i+1])
                b[i] = nums[i];
            else
                b[i] = b[i+1];
        }

        //3 再遍历原数组
        for (int i = 1; i < len-1; i++) {
            if (f[i-1]<nums[i]&&nums[i]<b[i+1])
                return true;
        }

        return false;
    }
}

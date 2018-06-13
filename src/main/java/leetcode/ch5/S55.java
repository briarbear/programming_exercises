package leetcode.ch5;

import java.util.HashSet;
import java.util.Set;

/**
 * 55 跳跃游戏
 * http://www.cnblogs.com/grandyang/p/4371526.html
 */
public class S55 {

//    Set<Integer> set = new HashSet<>();


    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length==1)
            return true;
        dp[0] = nums[0];
        if (dp[0] <=0)
            return false;
        //自底向上
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]-1,nums[i]);
            if (dp[i-1] <= 0)
                return false;
        }

        return true;
    }


    /**
     * 贪心法 reach记录的是当前能到达的最远处
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums){
        int len = nums.length,reach = 0;
        for (int i = 0; i < len; i++) {
            if (i > reach || reach >= len-1) break;
            reach = Math.max(reach,i+nums[i]);
        }
        return reach >= len-1;
    }


}

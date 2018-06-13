package leetcode.ch3;

import java.util.Arrays;
import java.util.Collections;

/**
 * 322 零钱兑换
 */
public class S322 {


    public int coinChange(int[] coins, int amount) {
        if (amount ==0)
            return 0;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        return helper(coins,dp,amount);

//        return greedy(coins,amount);
    }

    // 贪心法 可能无法求解正确答案
    public int greedy(int[] coins,int amount){
        int len = coins.length;
        int sum = 0,i = len-1,res = 0;
        if (amount == 0)
            return 0;
        //排序
        Arrays.sort(coins);
        while (i >= 0){
            sum += coins[i];
            res++;
            if (sum == amount)
                return res;
            if (sum < amount)
                continue;
            else {
                res--;
                sum -= coins[i--];
            }
        }

        return -1;
    }


    //动态规划 + 自底向上
    public int helper(int[] coins,int[] dp,int amount){
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;  //很精髓的地方
            for (int j = 0; j < coins.length; j++) {
                 if (coins[j] <= i){
                     //这种方式来筛选最下值
                     dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                 }
            }
        }

        return dp[amount] >amount?-1:dp[amount];
    }

}

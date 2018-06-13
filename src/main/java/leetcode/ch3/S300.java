package leetcode.ch3;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 300. 最长上升子序列  Longest Increasing Subsequence
 */
public class S300 {

    /**
     * 动态规划
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len<=1)
            return len;
        int[] dp = new int[len];  //dp[i]表示到以nums[i]个为结尾的最长递增序列长度
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            int temp = 0;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[i] > nums[j]){
                    //得到最大的dp[j]
                    temp = dp[j] > temp?dp[j]:temp;
                }
            }
            dp[i] = temp+1;
            max = dp[i]>max?dp[i]:max;
        }

        return max;
    }

    /**
     * O(nlogn)的复杂度
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums){

        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}

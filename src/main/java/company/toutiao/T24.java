package company.toutiao;

import java.util.Scanner;

/**
 * 今日头条笔试第二批第4题
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-25-11:01
 */
public class T24 {
    /**
     * 最长上升子序列
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt(); //每个小时的采样点个数
            int t = scanner.nextInt(); //询问小时

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int res = 0;
            if (t>n){
                int[] pm = new int[n*n];
                for (int i = 0; i < n*n; i++) {
                    pm[i] = array[i%n];
                }
                res = helper(pm)+ t-n;
            }else{
                int[] pm = new int[n * t];
                for (int i = 0; i < n * t; i++) {
                    pm[i] = array[i%n];
                }

                res = helper(pm);
            }



            System.out.println(res);
        }
    }

    public static int helper(int[] nums) {
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
                if (nums[i] >= nums[j]){
                    //得到最大的dp[j]
                    temp = dp[j] > temp?dp[j]:temp;
                }
            }
            dp[i] = temp+1;
            max = dp[i]>max?dp[i]:max;
        }

        return max;
    }
}

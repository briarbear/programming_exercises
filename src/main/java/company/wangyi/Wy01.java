package company.wangyi;

import java.util.Scanner;

/**
 * 网易编程题
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-11-14:50
 */
public class Wy01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt(); //n堆苹果
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            //使用dp[i]数组保存到第i堆的苹果总数
            int[] dp = new int[n+1];

            helper(dp,a,n);
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                System.out.println(find(dp,n,scanner.nextInt()));
            }

        }
    }


    /**
     * 找到第q个苹果
     */
    public static int find(int[] dp,int n,int q){

        //使用二分查找
        int begin = 1,end = n,mid;


        while (begin <= end){
            mid  = (begin+end)/2;
            if (dp[mid] < q)
                begin = mid+1;
            else if (dp[mid] > q){
                if (dp[mid-1] < q)
                    return mid;
                else
                    end = mid-1;
            }else
                return mid;
        }

        return n;
    }


    public static void helper(int[] dp,int[] a,int n){
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = sum + a[i-1];
            sum = dp[i];
        }
    }
}




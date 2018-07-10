package nowcoder;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * 牛客网袋鼠过河
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-09-16:41
 */
public class kangarooJump {

    public static int[] dp;
    public static void main(String[] args) {
        Scanner scanner  =  new Scanner(System.in);

        while (scanner.hasNext()){
            int len = scanner.nextInt(); //数组长度
            int[] arr = new int[len+1];

            //数组初始化
            for (int i = 0; i < len; i++) {
                arr[i] = scanner.nextInt();
            }

            dp = new int[len+1];
            for(int i = 0; i < len+1; dp[i] = -1,i++);
            helper(arr);
            if (dp[len] != -1)
                System.out.println(dp[len]);
            else
                System.out.println(dp[len-1]);
        }
    }


    /**
     * 处理方法
     * dp[i] 表示到达i处的最小步数
     */
    public static void helper(int[] arr){

        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= i-j && dp[j] != -1)
                    min = (dp[j]+1) < min ? dp[j]+1:min;
            }

            if (min == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = min;

        }
    }
}

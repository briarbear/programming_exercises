package company.wangyi;

import java.util.Scanner;

/**
 * 网易编程题2
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-11-14:50
 */
public class Wy02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt(); //课堂持续分钟数
            int k = scanner.nextInt(); //一次清醒时间
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }

            int[] clear = new int[n];
            for (int i = 0; i < n; i++) {
                clear[i]  = scanner.nextInt();
            }

            //初始分数
            int primaryScore = primaryScore(scores,clear,n);

            //最大值
            int max = primaryScore;
            for (int i = 0; i <= n - k; i++) {
                int temp = helper(scores,clear,i,k);
                if (primaryScore +temp > max)
                    max = primaryScore+temp;
            }

            System.out.println(max);
        }
    }


    /**
     * 初始的分数
     * @return
     */
    public static int primaryScore(int[] scores,int[] clear,int n){
        int sum  = 0;
        for (int i = 0; i < n; i++) {
            if (clear[i] == 1)
                sum += scores[i];
        }

        return sum;
    }

    /**
     * 滑动窗口 计算增加的分数
     */
    public static int helper(int[] scores,int[] clear,int begin,int k){

        int addSocore = 0;
        for (int i = begin; i < begin+k; i++) {
            if (clear[i] == 0)
                addSocore += scores[i];
        }

        return addSocore;
    }

}

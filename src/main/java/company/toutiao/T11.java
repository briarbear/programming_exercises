package company.toutiao;

import java.util.Scanner;

/**
 * 分组问题
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-25-10:19
 */
public class T11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt(); //n 个人
            int[][] links = new int[n][n];  //二维矩阵
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                while (t != 0){
                    links[i][t-1] = 1;
                    links[t-1][i] = 1;
                    t = scanner.nextInt();
                }
            }

            System.out.println("xiong");
        }
    }

    public int search(int[][] links,int[] n){
        //待完成

        return 0;
    }
}

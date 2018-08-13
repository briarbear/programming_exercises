package company.toutiao;

import java.util.Scanner;

/**
 * 头条编程题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-12 9:54
 */
public class Tt01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] size = scanner.next().split(",");
            int m = Integer.valueOf(size[0]);
            int n = Integer.valueOf(size[1]);
            int[][] seats = new int[m][n];
            //接受输入
            for (int i = 0; i < m; i++) {
                String[] str = scanner.next().split(",");
                for (int j = 0; j < n; j++) {
                    seats[i][j] = Integer.valueOf(str[j]);
                }
            }

            //计算球队群体人数
            boolean[][] visit = new boolean[m][n];
            int p = 0;
            int q = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]&&seats[i][j] == 1){
                        int temp = helper(seats,visit,i,j);
                        p++;
                        if (temp>q)
                            q = temp;
                    }
                }
            }
            System.out.println(p+","+q);
        }
    }

    /**
     * 深搜+回溯
     * @param seats
     * @return
     */
    public static int helper(int[][] seats,boolean[][] visit,int i,int j){
        int res = 0;
        if (!visit[i][j]&&seats[i][j] == 1){
            visit[i][j] = true;
            res = 1;
        }else
            res = 0;


        if (j<seats[0].length-1&&seats[i][j+1]==1&&!visit[i][j+1]) //右
            res += helper(seats,visit,i,j+1);
        if (i<seats.length-1&&seats[i+1][j]==1&&!visit[i+1][j]) //下
            res += helper(seats,visit,i+1,j);
        if (j>0&&seats[i][j-1]==1&&!visit[i][j-1])  //左
            res += helper(seats,visit,i,j-1);
        if (i>0&&seats[i-1][j]==1&&!visit[i-1][j])  //上
            res += helper(seats,visit,i-1,j);

        if (j<seats[0].length-1&&i<seats.length-1&&seats[i+1][j+1]==1&&!visit[i+1][j+1]) //右下
            res += helper(seats,visit,i+1,j+1);

        if (j>0&&i<seats.length-1&&seats[i+1][j-1]==1&&!visit[i+1][j-1]) //左下
            res += helper(seats,visit,i+1,j-1);
        if (j>0&&i>0&&seats[i-1][j-1]==1&&!visit[i-1][j-1]) //左上
            res += helper(seats,visit,i-1,j-1);
        if (j<seats[0].length-1&&i>0&&seats[i-1][j+1]==1&&!visit[i-1][j+1]) //右上
            res += helper(seats,visit,i-1,j+1);

        return res;
    }
}

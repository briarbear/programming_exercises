package Algorithm;

/**
 * 0-1背包问题
 */
public class Backages {

    public static void main(String[] args) {


        int[] weight = {0,2,1,3,2};
        int[] value = {0,12,10,20,15};
        int[][] f = new int[5][6];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (i == 0){
                    f[i][0] = 0;
                    continue;
                }
                if (j == 0){
                    f[0][j] = 0;
                    f[i][j] = 0;
                    continue;
                }
                if (j - weight[i] >=0)
                    f[i][j] = Math.max(f[i-1][j],value[i]+f[i-1][j-weight[i]]);
                else
                    f[i][j] = f[i-1][j];
            }
        }

        System.out.println(f[4][5]);
    }
}

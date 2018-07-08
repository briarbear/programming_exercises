package company.Ali;

/**
 * 数组插入
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-06-15:02
 */
public class InsertArray {

    static long[][] mem;

    static long min(int[] from, int[] to) {
        int len = from.length;
        if (len == 0)
            return 0;
        //记忆化数组
        mem = new long[len+1][len+1];

        return dp(0,0,from,to);
    }


    /**
     * dp[i,j] 表示计算到到form[i] to[j]
     */
    static long dp(int i,int j,int[] a,int[] b){
        long res = Long.MAX_VALUE;

        if (i == a.length && j == b.length)
            return 0;

        if (mem[i][j] != 0)  //记忆化结果
            return mem[i][j];

        if (i == a.length){
            res = b[j] * b[j+1] + dp(i,j+2,a,b);
        }else if (j == b.length){
            res = a[i] * b[i+1] + dp(i+2,j,a,b);
        }else {
            if (i + 1 < a.length)
                res = Math.min(res,a[i] * a[i+1] + dp(i+2,j,a,b));
            if (j + 1< b.length)
                res = Math.min(res,b[j] * b[j+1] + dp(i,j+2,a,b));
            if (i < a.length && j < b.length)
                res = Math.min(res,a[i] * b[j] + dp(i+1,j+1,a,b));
        }

        mem[i][j] = res;
        return res;
    }
}

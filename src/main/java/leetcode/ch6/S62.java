package leetcode.ch6;

/**
 * 62. 不同路径
 */
public class S62 {

    private int res = 0;
    private int[][] mem;
    public int uniquePaths(int m, int n) {

        //方法1 深度搜索
//        dps(m,n,0,0);
//        return res;

        //方法2 动态规划 + 记忆化
        mem = new int[n][m];
        return dp(n-1, m-1);
    }

    //深度搜索 超时
    public void dps(int m,int n,int i,int j){
        if (i == n-1 && j == m-1)
            res++;
        if (i<n-1)
            dps(m,n,i+1,j);
        if (j < m-1)
            dps(m,n,i,j+1);
    }

    public int dp(int i,int j){
        if (i==0 || j ==0 )
            return 1;
        if (mem[i][j] != 0)
            return mem[i][j];

         mem[i][j] = dp(i-1,j) + dp(i,j-1);

         return mem[i][j];
    }
}

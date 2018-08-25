package test;

import java.util.Scanner;

/**
 * 今日头条25日笔试第二题
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-25-11:43
 */
public class T7 {

    static long[][][] memo = new long[1001][600][5];
    static long mod = (long) 1e9 +7;
    public static void main(String[] args) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 600; j++) {
                for (int k = 0; k < 5; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n == 0)
                System.out.println(n);
            long ans = 10l * dfs(1,1,0,n) + dfs(1,3,1,n);
            ans %= mod;
            ans  = ( ans + mod) % mod;

            System.out.println(ans);
        }
    }


    public static long dfs(int u, int pre, int cnt, int n)
    {
        if (u == n){
            if (cnt == 0 && (pre == 1 || pre == 4)) return 1;
            else return 0;
        }

        if (cnt > n - u + 50) return 0;
        if (memo[u][cnt][pre] != -1) return memo[u][cnt][pre];
        long ans = 0;
        // number
        if (pre != 4)
            ans += 10l * dfs(u + 1, 1, cnt, n);
        // +
        if (pre == 1 || pre == 4)
            ans += 2l * dfs(u + 1, 2, cnt, n);

        // (
        if (pre == 2 || pre == 3)
            ans += dfs(u + 1, 3, cnt + 1, n);
        // )
        if ((pre == 1 || pre == 4) && cnt > 0)
            ans += dfs(u + 1, 4, cnt - 1, n);
        ans %= mod;
        memo[u][cnt][pre] = ans;
        return ans;
    }
}

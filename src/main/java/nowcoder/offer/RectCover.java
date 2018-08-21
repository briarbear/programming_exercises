package nowcoder.offer;

/**
 *
 */
public class RectCover {

    public int cover(int target){
        if (target == 0)
            return 0;

        int[] dp = new int[1000];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[target-1];
    }
}

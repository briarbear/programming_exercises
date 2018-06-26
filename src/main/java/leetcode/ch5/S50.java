package leetcode.ch5;

/**
 * 50 Pow(x,n)
 */
public class S50 {

    /**
     * 折半计算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n > 0)
            return helper(x,n);
        else
            return 1.0 / helper(x,-n);

    }

    public double helper(double x,int n){
        if (n == 0) return 1;
        double half = helper(x,n/2);

        if (n % 2 == 0)
            return half * half;
        return x * half * half;

    }
}

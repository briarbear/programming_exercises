package leetcode.ch2;

/**
 * 29. Divide Two Integers
 */
public class S29 {

    public int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        // 转化成：m / m
        long m  = Math.abs((long)dividend), n = Math.abs((long)divisor);
        long res = 0;
        // 记录结果的正负值
        int sign = 1;
        if ( (dividend >0 && divisor <0) || (dividend < 0 && divisor >0))
            sign = -1;
        if ( n == 1)  //除数为1的情况
            return (int) (sign == 1 ? m : -m);

        while ( m >= n){
            long t = n,p = 1;
            while (m >= (t << 1)){
                t = t<< 1;
                p = p<< 1;
            }

            res += p;
            m -= t;
        }

        return (int) (sign == 1 ? res : -res);
    }




    //移位实现除法
    public int helper(int x,int y){
        int left = x;
        int res = 0;


        while (left >= y){
            int m = 1;
            while (y*m <= left>>1)
                m = m<<1;

            res+=m;
            left -= y*m;
        }

        return res;
    }


}

package nowcoder.offer;

/**
 *
 */
public class NumberOf1 {

    /**
     * 移位再求与
     * @param n
     * @return
     */
    public int number(int n){
        if (n == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < 32; i++) {
            System.out.println(Integer.toBinaryString(n));
            res += n&1;
            n >>= 1;
        }


        return res;

    }

    /**
     * 从1到n整数中1出现的次数
     * @param n
     * @return
     */
    public int solution(int n){

        int res = 0,a = 1,b = 1;
        while (n > 0){

            res += (n + 8) / 10 * a;
            if ( n % 10 == 1) res += b;
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }

        return res;
    }
}

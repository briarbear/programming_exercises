package nowcoder;

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
}

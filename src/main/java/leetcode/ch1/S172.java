package leetcode.ch1;

/**
 *
 * 172  阶乘后的零
 */
public class S172 {

    //每五个数就会产生一个0，遇到5的幂则会多产生一个
    public int trailingZeroes(int n) {

        int res = 0;
        while (n > 0){
            res += n/5;
            n /=5;
        }
        return res;
    }
}

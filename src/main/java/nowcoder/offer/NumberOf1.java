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
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length; //该数字的长度
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = chars[len-i-1] - '0';  //倒置存储
        }
        int count = 1,temp = 1;
        for (int i = 0; i < len; i++) {
            int t = 1;
            if (num[i] > 1) ;
        }



    }
}

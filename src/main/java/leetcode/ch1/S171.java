package leetcode.ch1;

/**
 * 171. Excel表列序号
 */
public class S171 {


    public int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int temp = (int) Math.pow(26,len-i-1);
            temp = (ch[i] - 'A' + 1) * temp;
            res += temp;
        }

        return res;
    }
}

package leetcode.ch0;

/**
 * 5 最长回文字串
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-03-19:55
 */
public class S5 {

    /**
     * 利用一种中心点游标，然后向两边扩展，判断是否为回文字串
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 1,start= 0,end = 0;
        double p = 0;
        while (p<=len){

            int i = (int)(p-0.5);
            int j = (int)(p+1);

            while (i >= 0 && j < len) {
                if (chars[i] == chars[j]) {
                    int temp = j - i + 1;
                    if (temp>max){
                        max = temp;
                        start = i;
                        end = j;

                    }
                    i--;
                    j++;
                } else
                    break;

            }



            p += 0.5;  //移动0.5步
        }


        return s.substring(start,end+1);

    }

    /**
     * 尝试动态规划解决
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        char[] chars  = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];   //dp[i][j]表示s(i....j)的字串 是否为回文串

        for (int i = len-1;i>=0;i--){
            for (int j = i; j < len ; j++) {

            }
        }


    }
}

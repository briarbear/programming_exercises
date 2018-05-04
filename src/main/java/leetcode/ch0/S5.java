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
        //利用一种中心点游标,中心点游标每次移动0.5距离，然后向两边扩展，判断是否为回文字串
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
     * https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        char[] chars  = s.toCharArray();
        int len = chars.length;
        String res = null;
        boolean[][] dp = new boolean[len][len];   //dp[i][j]表示s(i....j)的字串 是否为回文串

        for (int i = len-1;i>=0;i--){  //从最右端开始
            for (int j = i; j < len ; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&(j-i<3 || dp[i+1][j-1]);

                //判断是否为最长
                if (dp[i][j] && (res == null || j-i+1 > res.length()))
                    res = s.substring(i,j+1);
            }
        }

        return res;

    }

    public String longestPalindrome3(String s) {
        //尝试从左端开始
        String res = null;
        int len = s.length();
        //dp二维数组 dp[i][j]表示s中从i到j的字串是否为回文字串
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                //如果两端的字母相等，且长度<=3 或者去掉两端的也符合回文串
                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i+1 <=3 || dp[i+1][j-1]);

                //判断是否为最长
                if (dp[i][j] && (res == null || j-i+1 > res.length()))
                    res = s.substring(i,j+1);
            }


        }

        return res;

    }


}

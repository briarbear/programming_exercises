package leetcode.ch3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters 无重复字符的最长子串
 */
public class S3 {

    //采用双游标的方案
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 1 || len == 0) {
            return len;
        }
        int res = 1;

        int i = 0, j = 1;
        while (j < len) {
            String s1 = s.substring(i, j);  //目前最长的字串
            char cRight = s.charAt(j);
            if (s.charAt(j) == s.charAt(j - 1))  //判断新增加的元素是不是与前一个元素重复
                i = j;                           //讲i光标移动到j
            else {
                if (s1.contains(String.valueOf(cRight))) {  //判断新加的元素是否为之前的重复元素
                    while (s.charAt(i) != cRight) i++;     //一直偏移，直到找到重复元素的位置
                    i++;
                }
            }

            res = (j - i + 1) > res ? (j - i + 1) : res;   //这样比if语言运行时间更短
            j++;
        }
        return res;
    }

    //leetcode最短时间
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int len = 1;
        int checkIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            len++;
            for (int j = checkIndex; j < i; j++) {
                if (chars[i] == chars[j]) {
                    if (maxLen < len - 1) {
                        maxLen = len - 1;
                    }
                    checkIndex = j + 1;
                    len = i - j;
                    break;
                }
            }
        }
        return Math.max(maxLen, len);
    }


    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int length = s.length();
        int len = 1, max = 1, left = 0;
        for (int r = 1; r < length; r++) {
            len++;
            for (int i = left; i < r; i++) {
                if (chars[i] == chars[r]) {
                    left = i + 1;
                    len = r - i;
                    if (max < len - 1)
                        max = len - 1;

                    break;
                }
            }
        }

        return max > len ? max : len;
    }

    //leetcode推荐方法2 滑动窗口
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();//保存目前的字符串
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n){

            //// try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++)); //i右移
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        String s = "ckilsbkd"; //ckilibkd
        System.out.println(new S3().lengthOfLongestSubstring4(s));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

package leetcode.ch7;

import java.util.Arrays;

/**
 * 76. Minimum Window Substring
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-08-18:28
 */
public class S76 {

    private String t;
    private int[] sn = new int[128];
    private int[] tn = new int[128];


    public String minWindow(String s, String t) {
        if (s.length()<t.length())
            return "";
        //分别将s、t保存在Ascii数组中
        for (int i = 0; i < s.length(); i++) {
            sn[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tn[t.charAt(i)]++;
        }
        this.t= t;

        int len1 = s.length();
        int len2 = t.length();

        int i = 0,j= i+len2,start= 0,end = start,min = len1+len2;
        while (i<=(len1-len2)){
            for (; j <= len1; j++) {
                //如果遇到的字符不在t中，直接跳过
                if (tn[s.charAt(j-1)]==0)
                    continue;
                //否则再去判断是否包含
                if (satisfy(s.substring(i,j))){
                    if (j-i<min){
                        start = i;end = j;
                        min = j-i;
                    }
                    break;
                }
            }

            for (i++; i < j&&j<=len1; i++) {
                //如果i位置的字符不在t中，同样地跳过
                if (tn[s.charAt(i)]==0)
                    continue;

                if (!satisfy(s.substring(i,j)))
                    break;
                    if (j-i<min){
                        start = i;
                        end = j;
                        min = j-i;
                    }
            }
        }

        if (start==end)
            return "";

        return s.substring(start,end);
    }
    //用ascii码数组来处理
    public boolean satisfy(String s){
        int[] n = new int[128];
        //对s进行处理，记录每个字母的次数
        for (int i = 0; i < s.length(); i++) {
            n[s.charAt(i)]++;
        }

        //再根据t字符串，处理n数组，如果某个位置的数字小于t中，则返回false
        for (int i = 0; i < t.length(); i++) {
            if (n[t.charAt(i)]<tn[t.charAt(i)])
                return false;
        }

        return true;
    }


    /**
     * 精简升级版 双指针结合Ascii表
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t){
        if (t.length()>s.length())
            return "";
        String res = "";
        int left = 0,count = 0,minLen = s.length()+1;
        int[] sn = new int[128]; //用来动态记录滑动窗口中字符出现的情况
        int[] tn = new int[128];

        //对t处理，存储到数组中
        for (int i = 0; i < t.length(); tn[t.charAt(i++)]++);

        for (int right = 0; right < s.length(); ++right) {
            //如果该位置的字符在t中，则
            if (tn[s.charAt(right)] != 0){
                sn[s.charAt(right)]++;  //sn记录扫描的字符出现的次数

                if (sn[s.charAt(right)] <= tn[s.charAt(right)]) count++; //count记录已匹配到字符的个数

                while (count == t.length()){
                    if (right-left+1 < minLen){
                        minLen = right - left +1;
                        res = s.substring(left,minLen+left);
                    }
                    //如果左边的字符在t中
                    if (tn[s.charAt(left)] != 0){
                        sn[s.charAt(left)]--;  //将sn中对饮字符次数减去1
                        if (sn[s.charAt(left)] < tn[s.charAt(left)]) //如果
                            count--;
                    }
                    left++;
                }

            }
        }

        return res;
    }



}

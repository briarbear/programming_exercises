package company.Ali;

import java.util.ArrayList;
import java.util.List;

/**
 * 7月6日 阿里中间件编程题
 *
 *
 * 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
 * pattern = “abba”, str=”北京 杭州 杭州 北京” 返回 true
 * pattern = “aabb”, str=”北京 杭州 杭州 北京” 返回 false
 * pattern = “baab”, str=”北京 杭州 杭州 北京” 返回 true
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-06-11:25
 */
public class S0706 {

    public static void main(String[] args) {

            S0706 s = new S0706();
            String input = "baab";
            String str = "北京 杭州 北京 上海";

        System.out.println(s.wordPattern(input,str));

    }


    public boolean wordPattern(String pattern,String str){
        String[] words = str.split(" ");  //
        if (pattern.length() != words.length)
            return false;

        int[] sign = new int[pattern.length()];  //标记数组
        for (int i = 0; i < pattern.length(); i++) {

            if (sign[i] == 0){
                List<Integer> arr = helper(pattern,pattern.charAt(i));
                for (Integer it : arr) {
                    sign[i]  = 1;
                    if (!words[i].equals(words[it]))
                        return false;
                }

            }

        }

        return true;

    }


    public List<Integer> helper(String s, char c){
        List<Integer> res = new ArrayList<>();

        for (int i = s.indexOf(c); i < s.length();) {
            int t = s.indexOf(c,i+1);
            if (t == -1)
                break;
            res.add(t);
            i = t;
        }

        return res;

    }



}

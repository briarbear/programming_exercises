package nowcoder;

import java.util.*;

/**
 * 字符串的所有组合情况
 * https://www.nowcoder.com/questionTerminal/837f4d04f5cb4f26a8215b2b95cc76a5
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-15-14:48
 */
public class Combination {


    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();

            helper2(input);
            list.sort(((o1, o2) -> {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            }));

            for (String s : list) {
                System.out.print(s+ " ");
            }

        }
    }


    public static void helper(String str){

        if (str==null||str.length()==0)return;

        if (list.contains(str))
            return;
        list.add(str);  //将str加入到set
        StringBuilder sb;
        for (int i = 0; i < str.length(); i++) {
             sb = new StringBuilder(str);
            helper(sb.deleteCharAt(i).toString());

        }


    }

    /**
     * 处理需要输出相邻的情况 如题目中要求
     * @param str
     */
    public static void helper2(String str){

        if (str==null||str.length()==0)return;

        if (list.contains(str))
            return;
        list.add(str);  //将str加入到set


        if (str.length()==1)
            return;

        helper2(str.substring(0,str.length()-1));
        helper2(str.substring(1,str.length()));


    }
}

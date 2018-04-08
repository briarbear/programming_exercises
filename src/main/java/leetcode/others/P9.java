package leetcode.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P9 {

    public static void main(String[] args) {


        System.out.println(isMatch("",".*"));
    }

    public static boolean isMatch(String s,String p){

        Pattern p1 = Pattern.compile(p);

        Matcher m = p1.matcher(s);
        boolean b = m.matches();

        return b;

    }
}

package ch1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转整形
 */
public class P8 {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("  010"));
    }


    public static int myAtoi(String str){


        str = str.trim();

        if (str.equals("")||str.equals("+")||str.equals("-"))
            return 0;
        Pattern p = Pattern.compile("^[ ]*[-+]{0,1}[0-9]*");
        Matcher m = p.matcher(str);
        boolean b = m.matches();

        if (!b)
            return 0;
        if (str.length()>11)
            return 0;
        long temp = Long.valueOf(str);
        if (temp>Integer.MAX_VALUE||temp<Integer.MIN_VALUE)
            return 0;
        int result = (int)temp;

        return result;

    }


}

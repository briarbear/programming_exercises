package leetcode.others;

public class P14 {

    public static void main(String[] args) {

        String[] str = new String[]{"a","b"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length==0)
            return "";
        String temp = null,s1 = "",s2 = "";
        int i = 1;
        while (i<=strs[0].length()){
            s2 = strs[0].substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()<i)
                    return s1;
                temp = strs[j].substring(0,i);
                if (!temp.equals(s2)){
                    s2 = s1;
                    break;
                }
            }
            s1 = s2;
            i++;
        }

        return s1;

    }
}

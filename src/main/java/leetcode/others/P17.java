package leetcode.others;

import java.util.*;

public class P17 {

    public static void main(String[] args) {


        System.out.println(letterCombinations(""));

    }

    /**
     * 用FIFO队列很好解决了双循环的问题
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new LinkedList<String>();
        LinkedList<String> res = new LinkedList<>();

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[x].toCharArray())
                    res.add(t+s);
            }
        }

        return res;
    }




}

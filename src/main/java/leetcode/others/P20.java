package leetcode.others;

import java.util.HashMap;
import java.util.Stack;

public class P20 {


    public static void main(String[] args) {
        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s){


        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length; i++) {
            if (!stack.empty()) {
                temp = stack.peek();
                if (!map.containsKey(temp))
                    return false;

                if (map.get(temp)!=chars[i])
                    stack.push(chars[i]);
                else
                    stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }

        return stack.empty();
    }
}

package leetcode.ch3;

import java.util.Stack;

public class P32_1 {


    public static void main(String[] args) {
        String s = "))((())";
        System.out.println(new P32_1().longestValidParentheses(s));
    }

    //栈
    public int longestValidParentheses(String s) {

        int maxans = 0;


        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);   //入栈的不是具体的元素，而是元素下标
            }else{
                stack.pop();
                if (stack.empty()){
                    stack.push(i);  //如果栈为空，说明遇到了')',这样操作，保证栈底存储这最后一个')'元素所在的位置
                }else {
                    maxans = Math.max(maxans,i - stack.peek());
                }
            }
        }


        return maxans;
    }
}

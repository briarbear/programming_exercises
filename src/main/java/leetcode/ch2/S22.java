package leetcode.ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22 括号生成
 */
public class S22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        //深度搜索，暴力搜索
        handle(1,n*2,"(");

        return res;
    }

    public void handle(int index,int n,String temp){

        if (index == n){
            if (judge(temp)){
                res.add(temp);
            }

        }else {
            if (n==5){
                handle(index+1,n,temp+")");
            }else {
                handle(index+1,n,temp+"(");
                handle(index+1,n,temp+")");
            }

        }
    }

    //判断字符串是否满足要求
    public boolean judge(String temp){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            char tc = temp.charAt(i);
            if (tc=='(')
                stack.push('(');
            else {
                if (stack.isEmpty()){
                    return false;
                }

                if (stack.peek() == '(')
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }


    //方法2 递归，
    /**
     * 而且最终结果必定是左括号3个，右括号3个，所以我们定义两个变量left和right分别表示剩余左右括号的个数
     * 如果某次递归时，剩余左括号的数量大于剩余右括号，则一定为非法串，直接返回
     */
    public List<String> generateParenthesis2(int n){

        List<String> res = new ArrayList<>();
        helper(n,n,"",res);

        return res;
    }

    /**
     * 在Java中，String作为参数，传递的是副本（值），而类对象作为参数，传递的是引用
     */
    private void helper(int left, int right, String out,List<String> res) {

        if (left < 0 || right < 0 || left > right)
            return;
        if (left==0&&right==0)
            res.add(out);
        helper(left-1,right,out+"(",res);
        helper(left,right-1,out+")",res);
    }

    /**
     * 方法3 回溯法
     */

    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    /**
     * 回溯函数 由于String参数的传值特性，体现了回溯的思想，即递归下一步的函数结束时，传递进去的原参数不变
     * @param ans 返回结果
     * @param cur 目前的字符串
     * @param open 左括号的数量
     * @param close 右括号的数量
     * @param max n长度
     */
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

         // 如果左括号数量小于n
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        // 如果右括号个数小于左括号，则增加右括号
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

}

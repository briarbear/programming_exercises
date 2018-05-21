package leetcode.ch1;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class S17 {

    /**
     * 暴力穷举
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        char[] input = digits.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(map[((int)input[i]-'0')]);
        }
        List<String> res = new ArrayList<>();
        if (digits.length()==0)
            return res;

        helper(list,0,"",res);
        return res;
    }

    public void helper(List<String> list,int index,String temp,List<String> res){
        if (index == list.size()-1){
            for (Character c : list.get(index).toCharArray()) {
                res.add(temp+String.valueOf(c));
            }
        }else {
            for (Character c : list.get(index).toCharArray()) {
                helper(list,index+1,temp+c,res);
            }
        }


    }


    /**
     * leetcode上提交的答案,算法复杂度一样，但更简洁
     * 使用 LinkedList链表
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits){
        if (digits.length() == 0)
            return new LinkedList<>();  //list的链表实现
        LinkedList<String> res =  new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");


        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            //获取头部元素，如果头部元素长度 == i,说明i刚好是要拼接的元素
            while (res.peek().length() == i){
                String t = res.remove();
                for (char c : mapping[x].toCharArray()) {
                    res.add(t+c);
                }
            }
        }

        return res;
    }
}

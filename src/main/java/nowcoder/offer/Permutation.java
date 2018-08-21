package nowcoder.offer;

import java.util.*;

/**
 * 字符串的全排列
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-15-12:57
 */
public class Permutation {

    //使用treeset按值顺序插入 使用LinkedSet按插入顺序排序
    Set<String> set = new TreeSet<>();
//    Set<String> set = new LinkedHashSet<>();

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str==null)
            return res;


        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            helper(str.substring(i,i+1),sb.deleteCharAt(i).toString());
        }


        for (String re : set) {
            res.add(re);
        }
        return res;

    }



    public void helper(String left,String right){

        if (right.length() <= 1)
            set.add(left+right);
        else {
            for (int i = 0; i < right.length(); i++) {
                StringBuilder sb = new StringBuilder(right);
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                helper(left+c,sb.toString());
            }
        }

    }


    public ArrayList<String> Permutation2(String str){

        helper2(str.toCharArray(),0);
        ArrayList<String> res = new ArrayList<>();

        for (String s : set) {
            res.add(s);
        }
        return res;

    }

    /**
     * 交换+回溯
     * @param chars
     * @param begin
     */
    public void helper2(char[] chars,int begin){
        if (chars==null||chars.length==0||begin<0||begin>chars.length-1)
            return;

        if (begin==chars.length-1)
            set.add(String.valueOf(chars));
        else {

            for (int i = begin; i < chars.length; i++) {
                swap(chars,begin,i);
                helper2(chars,begin+1);
                //恢复现场
                swap(chars,i,begin);
            }
        }

    }

    public void swap(char[] chars,int i,int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}

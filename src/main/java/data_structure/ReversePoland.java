package data_structure;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 栈的应用
 * https://blog.csdn.net/u011857433/article/details/79993385
 * 四则运算表达式求职，中缀表达式与后缀表达式转换
 */
public class ReversePoland {


    public static void main(String[] args) {

//        Calculation1("9 3 1 - 3 * + 10 2 / +");
        System.out.println(Calculation2("9 + ( 3 - 1 ) * 3 + 10 / 2"));
    }

    /**
     * 计算后缀表达式
     * @param inputString 9 3 1 - 3 * + 10 2 / + 以空格分隔
     */
    public static int Calculation1(String inputString){
        String[] input = inputString.split(" ");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            if (isNumber(s))  //如果是数字，则入栈
                stack.push(Integer.valueOf(s));
            else {
                //遇到运算符，则从栈中弹出两个数字，进行运算
                int n1 = stack.pop();
                int n2 = stack.pop();
                int res = 0;
                switch (s){
                    case "+":res = n1 + n2;break;
                    case "-":res = n2 - n1;break;
                    case "*":res = n1 * n2;break;
                    case "/":res = n2 / n1;break;
                }
                stack.push(res);
            }
        }

        return stack.pop();
    }

    /**
     * 将中缀表达式转化为后缀表达式
     * @param string 9 + ( 3 - 1 ) * 3 + 10 / 2
     * @return
     */
    public static String Calculation2(String string){
        Stack<String> stack = new Stack();
        String[] chars = string.split(" ");
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (isNumber(s)){
                if (res.length()==0)
                    res += s;
                else
                    res += " "+s;
            }else {
                if (s.equals("(")){
                    stack.push(s);
                }else {
                    if (s.equals(")")){
                        String t = "";
                        String s1 = "";
                        while (!(t = stack.pop()).equals("(")){
                             s1 += " "+t;
                        }
                        res += s1;
                    }else {
                        int priority = getPriority(s);
                        String s1 = "";
                        boolean flag = false;
                        while (!stack.empty()){
                            flag = false;
                            s1 = stack.pop();
                            if (s1.equals("(")){
//                                stack.push("(");
                                break;
                            }

                            if (getPriority(s1) >= priority){
                                res += " " + s1;
                                flag = true;
                            }
                        }
                        if (!s1.equals("") && !flag)
                            stack.push(s1);
                        stack.push(s);
                    }
                }


            }

        }

        while (!stack.empty()){
            res += " " + stack.pop();
        }


        return res;
    }


    //获取运算符的优先级
    public static int getPriority(String s){
        Map<String,Integer> map = new HashMap<>();
        map.put("+",0);
        map.put("-",0);
        map.put("*",1);
        map.put("/",1);
        map.put("(",2);
        map.put(")",2);


        return map.get(s);
    }

    public static boolean isNumber(String c){

        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");
        Matcher matcher = pattern.matcher(c);
        boolean res = matcher.find();
        return res;
    }
}

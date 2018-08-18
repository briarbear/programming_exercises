package company.huawei;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 第三题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-15 20:25
 */
public class T03 {

    private static int length;
    private static int i;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            length = input.length();
            i = 0;
            System.out.println(helper(input));
        }
    }

    private static int helper(String input) {

        if (i >= length) return -1;
        if (input.charAt(i++) != '(') return -1;
        char op = input.charAt(i++);
        if (input.charAt(i) != ' ') return -1;
        i++;
        int res;

        if (op == '+' || op == '*'){
            int val1 = handler(input);  //计算第一个数
            if (i >= length || val1 == -1 || input.charAt(i) != ' ') return -1;
            i++;
            int val2 = handler(input);  //计算第二个数
            if (val2 == -1) return -1;
            if (i >= length || input.charAt(i) != ')') return -1;
            i++;
            if (op == '+') return val1 + val2;
            else return val1 * val2;
        }else if (op=='^'){
            int val = handler(input);  //只有一个数
            if (val == -1 || i >= length || input.charAt(i) != ')') return -1;
            i++;
            return val+1;
        }else
            return -1;

    }

    /**
     * 计算一个操作数的结果
     * @param input
     * @return
     */
    private static int handler(String input){
        if (input.charAt(i) == '(')
            return helper(input);
        else if (Character.isDigit(input.charAt(i))){
            int temp = 0;
            while (i < length && Character.isDigit(input.charAt(i))){
                temp = temp * 10 +input.charAt(i++) -'0';
                if (temp > Integer.MAX_VALUE)return -1;
            }
            return temp;
        }

        return 0;
    }

}

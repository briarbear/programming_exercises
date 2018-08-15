package company.huawei;

import java.util.Scanner;

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

        char c = input.charAt(i++);
        if(c == ')')
            return -1;

        if (c == '('){
            char op = input.charAt(i++);
            int flag = 0;
            switch (op){
                case '+':flag = 1;break;
                case '*':flag = 2;break;
                case '^':flag = 3;break;
                case '(':break;
                default:break;
            }





            char blank = input.charAt(i++);
            if (blank != ' ')
                return -1;
            char left = input.charAt(i++);
            int le;
            int ri = 0;
            switch (left){
                case '(':i--;le = helper(input);break;
                case ')':return -1;
                default:le = left - '0';break;
            }

            blank = input.charAt(i++);

            if (flag == 3){
                switch (blank){
                    case ')':return le+1;
                }
            }

            switch (blank){
                case ' ':break;
                case '(':i--;ri = helper(input);break;
            }



            char end = input.charAt(i++);
            if (end != ')')
                return -1;
            switch (flag){
                case 1:return le + ri;
                case 2:return le * ri;
                case 3:return le+1;
            }
        }


        return -1;
    }

    private static int handler(){
        return 0;
    }

}

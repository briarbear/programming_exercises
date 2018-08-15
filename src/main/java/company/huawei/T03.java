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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            length = input.length();
            System.out.println(helper(0,input));
        }
    }

    private static int helper(int i, String input) {


        return -1;
    }


}

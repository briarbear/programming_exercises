package company.huawei;

import java.util.Scanner;

/**
 * 第一题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-15 19:48
 */
public class T01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            StringBuilder res = new StringBuilder();
            int[] hash = new int[255];
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (hash[c] ==0){
                    res.append(c);
                    hash[c] = 1;
                }
            }

            System.out.println(res);
        }
    }
}

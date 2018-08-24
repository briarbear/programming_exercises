package company.zhihu;

import java.util.Scanner;
import java.util.Stack;

/**
 * 知乎编程题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-24 18:37
 */
public class T01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        while (scanner.hasNext()){
            int n  = scanner.nextInt();
            while (n > 0){

                res.insert(0,(n&1));
                n = n>>1;
            }
            System.out.println(res.toString());
            res.delete(0,res.length());
        }
    }
}

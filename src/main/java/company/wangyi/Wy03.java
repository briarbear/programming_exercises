package company.wangyi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 网易编程题
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-11-16:37
 */
public class Wy03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int n = scanner.nextInt(); //n个a
            int m = scanner.nextInt(); //m个z
            int k = scanner.nextInt(); //第k个字符串

            LinkedList<String> res = helper(n,m);

            res.sort((a,b) -> {
                return a.compareTo(b);
            });

            int i = 1;
            for (String re : res) {
                if (i++ == k)
                    System.out.println(re);
            }

        }



    }



    public static LinkedList<String> helper(int n,int m){

        LinkedList<String> res = new LinkedList<>();

        char c1 = 'a',c2 = 'z';
        if (n < m){
            c1 = 'z';
            c2 = 'a';
            n = n+m;
            m = n-m;
            n = n-m;
        }


        int space = n+1; //产生n+1个空位

        char[] str = new char[n*2+1];

        for (int i = 1; i < n; i = i*2+1) {
            str[i] = c1;
        }

        //剩下n+1个空中填入m个字符


        return res;

    }

}

package company.huawei;

import java.util.Scanner;

/**
 * 第二题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-15 19:58
 */
public class T02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int[] hour = new int[24];
            String input;
            //处理输入
            while (!(input = scanner.next()).equals("-1,-1")){
                String[] split = input.split(",");
                int start = Integer.valueOf(split[0]);
                int end = Integer.valueOf(split[1]);
                for (int i = start; i < end; i++) {
                    hour[i]++;
                }

            }

            //输出
            for (int i = 12; i < 20; i++) {
                System.out.println("["+i+","+(i+1)+"):"+hour[i]);
            }




        }
    }
}

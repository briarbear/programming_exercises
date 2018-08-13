package company.toutiao;

import java.util.Scanner;

/**
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-12 9:55
 */
public class Tt04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            //接受输入
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }


            //dpa[i,j]表示a[i,j]的最大值



            int count = 0;
            for (int i = 0; i < n; i++) {

                int max = a[i];
                int min = b[i];
                for (int j = i; j < n; j++) {
                    if (a[j]>max) max = a[j];
                    if (b[j]<min) min = b[j];

                    if (max<min) count++;
                }
            }

            System.out.println(count);
        }
    }




}

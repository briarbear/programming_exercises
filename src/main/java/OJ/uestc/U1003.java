package OJ.uestc;

import java.util.Scanner;

public class U1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a*b-1);

        }

    }
}

package Tencent;
        import java.math.BigInteger;
        import java.util.Scanner;
public class Throw_glass_ball {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            BigInteger nB = BigInteger.valueOf(n);
            BigInteger mB = BigInteger.valueOf(m);

            System.out.println((nB.multiply(mB)).divide(BigInteger.valueOf(2)));
        }
    }

}

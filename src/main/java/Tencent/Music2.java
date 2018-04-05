package Tencent;

import java.util.Scanner;

public class Music2 {


    private static int mod = 1000000007;
   public static int AA(int a,int n){

       int c = 1;
       for (int i = 0; i < n; ++i) {
           c = c * (a - i) % mod;
       }
       return c;
   }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0,k= 0,a=0,na=0,b=0,nb=0;
        while (in.hasNextInt()) {//注意while处理多个case

            if (count % 2 == 0) {

                k = in.nextInt();
            } else {
                a = in.nextInt();
                na = in.nextInt();
                b = in.nextInt();
                nb = in.nextInt();
            }

            count++;

            if (count %2 ==0){
                int ans = 0;
                for (int la = 0; la <= na; ++la) {
                    if (k - la * a >= 0 && (k - la * a) % b == 0 && (k - la * a) / b <= nb) {
                        int T = la + (k - la * a) / b;
                        ans += AA(na, la) % mod * AA(nb, T - la) % mod;
                    }
                }

                System.out.println(ans%mod);
            }
        }

    }

}

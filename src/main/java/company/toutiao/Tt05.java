package company.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-12 9:55
 */
public class Tt05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TV> tvs = new ArrayList<>();
        int count = 0;
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                TV tv = new TV(scanner.nextInt(), scanner.nextInt());
                if (tv.b < tv.a)
                    tv.b += m;
                tvs.add(tv);
            }

            for (int i = 0; i < n; i++) {
                if (tvs.get(i).b <= m){
                    tvs.get(n + count).a = m + tvs.get(i).a;
                    tvs.get(n+count).b  = m + tvs.get(i).b;
                    count++;
                }
            }

            tvs.sort(((o1, o2) -> {
                return o1.b - o2.b;
            }));
            
            int j = 0,k = 0;
            for (int i = 0; i < ; i++) {
                
            }
        }
    }
}


class TV{
    int a;
    int b;

    public TV(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
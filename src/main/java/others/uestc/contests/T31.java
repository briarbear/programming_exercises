package others.uestc.contests;

import java.util.Scanner;

public class T31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long[] input = new long[n];
            int sum = 0;
            int i = 0;
            for (; i < n ; i++) {
                input[i] = scanner.nextInt();
                sum += input[i];
//                sum = sum > 100000000||sum < -100000000?sum % 10000007:sum;
            }

            long max1 = getMax(input,i);
            long max2 = getMax(input,i-1);


            for (int j  = 1; j <= k ; j++) {
                long temp = max1+max2;

                long[] ints = new long[3];
                ints[0] = temp;
                ints[1] = max1;
                ints[2] = max2;

                max1 = getMax(ints,3);
                max2 = getMax(ints,2);

                sum += temp > 100000000 ? temp % 10000007:temp;
            }


            System.out.println(sum);

        }

    }

    public static long getMax(long[] n,int end){
        for (int i = 0; i < end-1; i++) {
            if (n[i]>n[i+1]){
                long temp = n[i];
                n[i] = n[i+1];
                n[i+1] = temp;
            }
        }

        return n[end-1];
    }

}

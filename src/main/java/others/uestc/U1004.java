package others.uestc;

import java.util.Scanner;

/**
 * Clock
 */
public class U1004 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String[] s = scanner.next().split(":");
            int hour = Integer.valueOf(s[0]);
            int mimute = Integer.valueOf(s[1]);
            System.out.println(handle(hour,mimute));

        }
    }

    public static String handle(int hour,int minute){
        int h = 30*(hour%12);
        if (minute % 2 ==0){
            h += minute/2;
            int res = Math.abs(minute*6-h);
            res = res>180?360-res:res;
            return String.valueOf(res);
        }else {

            return cal(minute*6,2*h+minute);
        }


    }

    //计算 a - b/2
    public static String cal(int a,int b){

        int res =  a*2 -b >= 0?a*2-b:b-a*2;
        res = res>360?720-res:res;
        return res + "/2";
    }
}

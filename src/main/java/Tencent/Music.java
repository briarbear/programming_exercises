package Tencent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0,k= 0,a=0,x=0,b=0,y=0;
        while (in.hasNextInt()) {//注意while处理多个case

            if (count%2==0){

                k = in.nextInt();
            }else {
                a = in.nextInt();
                x = in.nextInt();
                b = in.nextInt();
                y = in.nextInt();
            }

            count++;

            if (count%2==0){
                int number = 0;
                List<String> res = combine(k,a,x,b,y);
                for (String re : res) {
                    String[] strings = re.split(" ");
                    int na = Integer.valueOf(strings[0]);
                    int nb = Integer.valueOf(strings[1]);
                    number += calcute(x,na)*calcute(y,nb);
                }

                System.out.println(number);


            }

        }
    }


    public static int calcute(int m,int n){
        //m>n
        return jc(m)/(jc(n)*jc(m-n));
    }

    public static int jc(int n){
        int res = 1;
        while (n>0)
            res *= n--;

        return res;
    }


    public static List<String> combine(int k,int a,int x,int b,int y){

        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if ((a*i + b*j)>k)
                    break;
                if ((a*i + b*j)==k){ //如果
                    String s = i+ " " + j;
                    res.add(s);
                }

            }
        }

        return res;
    }

}

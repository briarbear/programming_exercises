package others.uestc.contests;

import java.util.Scanner;

/**
 * Prime
 */
public class T02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String letter = scanner.next();
            int start = scanner.nextInt();

            if (letter.equals("END"))
                break;
            System.out.println(handle(letter,start));

        }


    }


    public static String handle(String letter,int start){
        int r1 =  2;
        boolean flag = false;
        String r2 = letter;

        //找到下一个
        for (int i = start; i <= 9973; i++) {
            if (start==0||start==1){
                flag = true;
                break;
            }

            if (isPrime(i)){
                r1 = i;
                flag = true;
                break;
            }
        }

        //字母往下走一位
        if (!flag){
            r2 = nextLetter(letter);
        }

        return r2 + " " + String.format("%04d",r1);
        
    }


    public static String nextLetter(String letter){
        String res;
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char one  = letter.charAt(0);
        char two = letter.charAt(1);
        char three = letter.charAt(2);

        int lo0 = str.indexOf(one);
        int lo1 = str.indexOf(two);
        int lo2 = str.indexOf(three);

        if (lo2 == 25){
            lo2 = 0;
            lo1++;
            if (lo1>=25){
                lo1 = 0;
                lo0++;
            }
        }else {
            lo2++;
        }

        res = String.valueOf(str.charAt(lo0))+String.valueOf(str.charAt(lo1))+String.valueOf(str.charAt(lo2));
        return res;
    }

    //判断是否为质数
    public static boolean isPrime(int num){
        int temp = (int) Math.sqrt(num);

        for (int i = 2 ; i <= temp; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

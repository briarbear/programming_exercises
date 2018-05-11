package Ali;

import java.util.Scanner;

/**
 * 阿里实习生研发Java在线笔试
 */
public class S0511 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println(我是阿里旺旺，我在重复说话重复说话重复说话);


        while (scanner.hasNext()){
            String input = scanner.next();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] con = new int[n][n];

            for (int i = 0; i < m; i++) {
                String s = scanner.next();
                String[] chars = s.split(",");
                con[1][1] = 1;
                con[Integer.valueOf(chars[0])-1][Integer.valueOf(chars[1])-1] = 1;
            }


            System.out.println(handle(m,m,con));
        }

    }


    public static String handle(int n,int m,int[][] con){
        String res = "no";
        for (int i = 0; i < n ; i++) {

        }


        return res;
    }

    public static boolean deal(int start,int n){
        if (start == Math.pow(2,n) || start == Math.pow(2,n)-1)
            return true;
        int next1,next2;
        if (start %2 == 0){
            next1 = start+2;
            next2 = start+3;
        }else {
            next1 = start+1;
            next2 =start+2;
        }

        return deal(next1,n) || deal(next2,n);
    }

}

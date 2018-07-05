package others.uestc.contests;

import java.util.Scanner;

public class T33 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] map = new int[128];
        map['a'] = 6;map['b'] = 27;map['c'] = 3;map['d'] = 9;
        map['e'] = 7;map['f'] = 1;map['h'] = 0;map['i'] = 27;
        map['j'] = 0;map['k'] = 28;map['l'] = 1;map['m'] = 3;
        map['n'] = 24;map['o'] = 24;map['p'] = 8;map['q'] = 0;
        map['r'] = 5;map['s'] = 8;map['t'] = 28;map['u'] = 21;
        map['v'] = 0;map['w'] = 0;map['x'] = 0;map['y'] = 5;
        map['z'] = 4;map['g'] = 0;map['0'] = 33;map['1'] = 100;
        map['2'] = 100;map['3'] = 15;map['4'] = 8;map['5'] = 39;
        map['6'] = 53;map['7'] = 7;map['8'] = 9;map['9'] = 6;
        map['0'] = 33;


        while (scanner.hasNext()){
            char c = scanner.next().charAt(0);
            System.out.println(map[c]);
        }
    }
}

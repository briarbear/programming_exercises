package OJ.uestc.contests;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class T02Test {

    @Test
    public void test(){

        System.out.println(String.format("%03d",2));
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] input1 = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            input1[i] = random.nextInt(1000);
        }
        int[] input2 = new int[100];
        for (int i = 0; i < 100; i++) {
            input2[i] = RandomUtils.nextInt(1000,9999);
        }



        for (int i = 0; i < 100; i++) {
            String s = String.format("%03d",input1[i]);
            String a = String.valueOf(str.charAt(s.charAt(0)-'0'));
            String b = String.valueOf(str.charAt(s.charAt(1)-'0'));
            String c = String.valueOf(str.charAt(s.charAt(2)-'0'));
            String input = a+b+c;

            for (int j = 0; j < 100; j++) {
//                String string = input + " " +input2[i];
                System.out.println(T02.handle(input, input2[j]));
            }

        }




    }

}
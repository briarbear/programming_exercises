package leetcode.ch3;

import org.junit.Test;

import static org.junit.Assert.*;

public class S334Test {

    @Test
    public void increasingTriplet() {
        S334 s = new S334();
//        int[] ints = new int[]{2,1,0,2,0,2,0,2,0,2,0,1};
//        int[] ints = new int[]{1,2,3,1,2,1};
//        int[] ints = new int[]{4,7,2,1,5,6};
        int[] ints = new int[]{4,7};
//        System.out.println(s.increasingTriplet(ints));
        System.out.println(s.increasingTriplet4(ints));
    }
}
package leetcode.ch5;

import org.junit.Test;

import static org.junit.Assert.*;

public class S55Test {

    @Test
    public void canJump() {
        S55 s = new S55();
        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(s.canJump(nums));
    }
}
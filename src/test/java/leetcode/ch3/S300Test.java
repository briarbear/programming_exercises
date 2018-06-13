package leetcode.ch3;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class S300Test {

    @Test
    public void lengthOfLIS() throws Exception {
        int[] ints = new int[]{4,10,4,3,8,9};
        System.out.println(InstanceUtils.get(S300.class).lengthOfLIS(ints));

    }
}
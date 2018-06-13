package leetcode.ch3;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class S322Test {

    @Test
    public void coinChange() throws Exception{
        int[] coins = new int[]{1};
        System.out.println(InstanceUtils.get(S322.class).coinChange(coins, 1));

    }
}
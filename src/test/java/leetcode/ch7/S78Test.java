package leetcode.ch7;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class S78Test {

    @Test
    public void subsets() {
        S78 s = new S78();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res.size());
    }
}
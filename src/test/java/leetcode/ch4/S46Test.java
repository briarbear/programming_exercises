package leetcode.ch4;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class S46Test {

    @Test
    public void permute() {
        S46 s = new S46();
        int[] n = new int[]{1,2,3};
        List<List<Integer>> res = s.permute(n);
        String input = "【520告白日】湖中深情相对的两只水雉，中国九江市(© Jie Zhao/Getty News）";
        String[] ss = input.split("[(,（]");
        Assert.assertEquals(2,ss.length);


    }
}
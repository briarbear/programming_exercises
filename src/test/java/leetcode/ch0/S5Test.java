package leetcode.ch0;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class S5Test {

    @Test
    public void longestPalindrome1() {
        S5 test = new S5();
        Assert.assertEquals("bab",test.longestPalindrome1("babad"));
    }

    @Test
    public void longestPalindrome2() {

        S5 s5 = new S5();
        Assert.assertEquals(5,s5.longestPalindrome3("ababa").length());
    }
}
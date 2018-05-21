package leetcode.ch2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class S22Test {

    @Test
    public void generateParenthesis() {
        S22 s = new S22();
        List<String> res = s.generateParenthesis2(3);
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
}
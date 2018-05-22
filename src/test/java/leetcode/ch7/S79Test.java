package leetcode.ch7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class S79Test {

    @Test
    public void find() {
        S79 s = new S79();

//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};


        boolean res = s.exist(board,"CDA");
        Assert.assertEquals(true,res);
        System.out.println("");
    }
}
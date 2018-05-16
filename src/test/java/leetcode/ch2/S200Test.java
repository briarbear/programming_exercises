package leetcode.ch2;

import org.junit.Test;

import static org.junit.Assert.*;

public class S200Test {

    @Test
    public void numIslands() {
//        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        S200 s = new S200();
        System.out.println(s.numIslands(grid));

    }
}
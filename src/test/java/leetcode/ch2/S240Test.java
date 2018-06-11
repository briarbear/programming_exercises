package leetcode.ch2;

import org.junit.Test;

import static org.junit.Assert.*;

public class S240Test {

    @Test
    public void searchMatrix() {
        int[][] ints = new int[][]{{1,4,7,11,15},{2,5,8,2,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] n1 = new int[][]{};
        S240 s = new S240();
        System.out.println(s.searchMatrix(n1, 10));
    }
}
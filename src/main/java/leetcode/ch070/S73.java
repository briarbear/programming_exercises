package leetcode.ch070;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 73 Set Matrix Zeroes 矩阵置零
 */
public class S73 {
    // 1. 暴力破解 勉强通过
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int row = matrix.length,col = matrix[0].length; //row行数 col列数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        List<Integer> hzero = new ArrayList<>();
        List<Integer> lzero = new ArrayList<>();

        for (List<Integer> re : res) {
            int h = re.get(0);
            int l = re.get(1);
            if (!hzero.contains(h))
                hzero.add(h);
            if (!lzero.contains(l))
                lzero.add(l);
        }

        set(matrix,hzero,lzero);
    }

    //
    public void set(int[][] matrix,List<Integer> row,List<Integer> col){

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for (Integer integer : row) {
            for (int i = 0; i < colLength; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : col) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][integer] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,0},{5,6,7,8,},{9,0,11,12},{13,14,15,16}};
        int[][] m1 = {{0},{1}};
        new S73().setZeroes(m1);
        System.out.println(matrix);
    }
}

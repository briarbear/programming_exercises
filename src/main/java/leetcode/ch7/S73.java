package leetcode.ch7;

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

    //2. 方法2
    public void setZeroes2(int[][] matrix){
        int row = matrix.length,col = matrix[0].length; //分别获取矩阵的行和列
        int row0 = 1,col0 = 1;
        //0. 先记录第一行或者第一列中是否包含元素0，用变量记录
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0){
                row0 = 0;
                break;
            }

        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0){
                col0 = 0;
                break;
            }

        }

        //1. 从matrix[1][1]元素开始,开始遍历，如果等于0，则将matrix[0][j] matrix[i][0]即行首，列首元素置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j]==0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        //2. 从matrix[1][1]元素开始，同样遍历矩阵，如果行首或者列首元素为0，则置0

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j]==0)
                    continue;
                if (matrix[0][j]==0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        //3. 处理第一行或者第一列
        if (row0==0){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (col0==0){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

    }

    //3. 执行时间为1s的最优解
    public void setZeroes3(int[][] matrix){
        int col0 = 1, row = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 0;  //表示第一列应全置0
            for (int j = 1; j < cols; j++) {  //从第二列开始
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        //倒序遍历矩阵
        for (int i = row-1; i >= 0; i--) {
            for (int j = cols-1 ; j >=0 ; j--) {
                if (matrix[i][0] ==0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

            if (col0==0)
                matrix[i][0] = 0;
        }

    }

    //4. 和我最开始的暴力破解几乎一样，更好理解
    public void setZeroes4(int[][] matrix){

        int row = matrix.length, cols = matrix[0].length;
        int[] row0 = new int[row]; //用来记录该行是否为0
        int[] cols0 = new int[cols]; //用来记录该列是否为0

        //1. 遍历矩阵
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) //如果某个元素为0，则记录到两个一维数组中
                    row0[i] = cols0[j] = 1;
            }
        }

        //2.修改数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (row0[i]==1||cols0[j]==1)
                    matrix[i][j] = 0;
            }
        }
        //3.完美
    }



    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,0},{9,0,11,12},{13,14,15,16}};
        int[][] m1 = {{0,1}};
        new S73().setZeroes3(matrix);

    }
}

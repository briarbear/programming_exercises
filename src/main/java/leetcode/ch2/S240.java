package leetcode.ch2;

/**
 * 240. 搜索二维矩阵 II
 */
public class S240 {


    public boolean searchMatrix(int[][] matrix, int target) {

        //从坐下角开始
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int row = matrix.length;

        int col = matrix[0].length;

//        int[][] flag = new int[row][col];


        return helper(matrix,row-1,0,target);

    }

    public boolean helper(int[][] matrix,int i,int j,int target){

        int temp = matrix[i][j];
//        System.out.println(temp);
        if (temp==target)
            return true;
        if (temp > target){
            //往上走
            if (i > 0)
                return helper(matrix,i-1,j,target);
            else
                return false;
        }else {
            //往右走
            if (j<matrix[0].length-1)
                return helper(matrix,i,j+1,target);
            else {
                return false;
            }
        }

    }
}

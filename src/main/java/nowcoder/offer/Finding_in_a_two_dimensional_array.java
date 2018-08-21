package nowcoder.offer;

/**
 * 二维数组中的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 */
public class Finding_in_a_two_dimensional_array {

    private int col; //列
    private int row; //行
    public boolean Find(int target, int [][] array) {
        if (array==null||array.length < 1 || array[0].length<1)
            return false;
        row = array.length;
        col = array[0].length;

        return helper(target,array,row-1,0);
    }

    public boolean helper(int target,int[][] array,int i,int j){
        int temp = array[i][j];
        if (temp == target)
            return true;

        if (temp > target){
            if (i>0)
                return helper(target,array,i-1,j);  //往上走
            else
                return false;
        }else {
            if (j < col-1)
                return helper(target,array,i,j+1); //往右走
            else
                return false;
        }
    }
}

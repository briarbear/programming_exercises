package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-03-19:49
 */
public class PrintMatrix {

    public ArrayList<Integer> print(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
            return res;

        int col = matrix[0].length;
        int[][] sign = new int[row][col];  //标记是否访问过
        int i = 0, j = 0, flag = 0, count = 0;  //0 右 1 下 2 左 3 上
        while (true) {
            if (sign[i][j] == 0) {
                res.add(matrix[i][j]);
                sign[i][j] = 1;
                count++;
            }

            if (count >= row * col)
                break;
            switch (flag % 4) {
                case 0:
                    if (j < col - 1 && sign[i][j + 1] == 0) {
                        j++;
                        continue;
                    } else {
                        flag++;
                        continue;
                    }
                case 1:
                    if (i < row - 1 && sign[i + 1][j] == 0) {
                        i++;
                        continue;
                    } else {
                        flag++;
                        continue;
                    }
                case 2:
                    if (j > 0 && sign[i][j - 1] == 0) {
                        j--;
                        continue;
                    } else {
                        flag++;
                        continue;
                    }
                case 3:
                    if (i > 0 && sign[i - 1][j] == 0) {
                        i--;
                        continue;
                    } else {
                        flag++;
                        continue;
                    }
            }
        }

        return res;
    }
}

package leetcode.ch7;

/**
 * 79 单词搜索
 */
public class S79 {

    public boolean exist(char[][] board, String word) {
        return start(board, word);
    }


    public boolean start(char[][] board,String word){

        int row = board.length;
        if (row == 0)
            return false;
        int col = board[0].length;
        int[][] visited = new int[row][col];

        //依次尝试每一个点作为起始点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (find(board,word,visited,0,i,j)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean find(char[][] board,String word,int[][] visited,int index,int i,int j){

        visited[i][j] = 1; //该点被访问过


        if (word.charAt(index) == board[i][j]){
            if (index==word.length()-1)
                return true;

            boolean right = false,down = false,left= false,up =false;
            //再往四个方向走
            if (j < board[0].length-1 && visited[i][j+1] ==0)
                right = find(board,word,visited,index+1,i,j+1);

            if (i < board.length-1 && visited[i+1][j] ==0)
                down = find(board,word,visited,index+1,i+1,j);


            if (j > 0 && visited[i][j-1] ==0)
                left = find(board,word,visited,index+1,i,j-1);


            if (i > 0 && visited[i-1][j] ==0)
                up = find(board,word,visited,index+1,i-1,j);

            if (right||down||left||up)
                return true;
            else {

                //恢复现场
                visited[i][j] = 0;
                return false;
            }

        }

        //恢复访问状态
        visited[i][j] = 0;

        return false;


    }

}

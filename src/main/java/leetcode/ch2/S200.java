package leetcode.ch2;

/**
 * 200. 岛屿的个数
 */
public class S200 {




    /**深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int row = grid.length;
        if (row==0)
            return 0;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j]&&grid[i][j] == '1'){
                    helper(grid,visit,i,j);
                    count++;
                }
            }
        }


        return count;
    }

    public void helper(char[][] grid,boolean[][] visit,int i,int j){
        if (!visit[i][j]&&grid[i][j] == '1'){
            visit[i][j] = true;
        }

        if (j<grid[0].length-1&&grid[i][j+1]=='1'&&!visit[i][j+1])
            helper(grid,visit,i,j+1);
        if (i<grid.length-1&&grid[i+1][j]=='1'&&!visit[i+1][j])
            helper(grid,visit,i+1,j);
        if (j>0&&grid[i][j-1]=='1'&&!visit[i][j-1])
            helper(grid,visit,i,j-1);
        if (i>0&&grid[i-1][j]=='1'&&!visit[i-1][j])
            helper(grid,visit,i-1,j);
    }
}

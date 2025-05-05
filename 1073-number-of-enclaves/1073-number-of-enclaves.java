class Solution {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            if(grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid, i, 0, vis);
            }
            if(grid[i][col - 1] == 1 && !vis[i][col - 1]) {
                dfs(grid, i, col - 1, vis);
            }
        }

        for(int j = 0; j < col; j++) {
            if(grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid, 0, j, vis);
            }
            if(grid[row - 1][j] == 1 && !vis[row - 1][j]) {
                dfs(grid, row - 1, j, vis);
            }
        }

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    // dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
    
        for(int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];

            if(newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 1 && !vis[newx][newy]) {
                dfs(grid, newx, newy, vis);
            }
        }
    }
}
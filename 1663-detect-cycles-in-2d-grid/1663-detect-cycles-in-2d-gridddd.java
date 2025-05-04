class Solution {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (!vis[i][j]) {
                    if (dfs(grid, i, j, -1, -1, vis, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int x, int y, int prevX, int prevY, boolean[][] vis, char val) {
        vis[x][y] = true;

        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if(grid[newX][newY] == val) {
                    if(!vis[newX][newY]) {
                        if(dfs(grid, newX, newY, x, y, vis, val)) {
                            return true;
                        }
                    }
                    else if((newX != prevX) || (newY != prevY)) {
                        return true;
                    }
                }
            } 
        }
    return false;
    }
}

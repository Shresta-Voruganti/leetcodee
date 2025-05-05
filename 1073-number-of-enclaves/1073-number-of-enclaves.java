class Solution {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            if(grid[i][0] == 1 && !vis[i][0]) {
                bfs(grid, i, 0, vis);
            }
            if(grid[i][col - 1] == 1 && !vis[i][col - 1]) {
                bfs(grid, i, col - 1, vis);
            }
        }

        for(int j = 0; j < col; j++) {
            if(grid[0][j] == 1 && !vis[0][j]) {
                bfs(grid, 0, j, vis);
            }
            if(grid[row - 1][j] == 1 && !vis[row - 1][j]) {
                bfs(grid, row - 1, j, vis);
            }
        }

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    // bfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public void bfs(int[][] grid, int i, int j, boolean[][] vis) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if(newx >= 0 && newx < row && newy >= 0 && newy < col && grid[newx][newy] == 1 && !vis[newx][newy]) {
                    q.offer(new int[]{newx, newy});
                    vis[newx][newy] = true;
                }
            }
        }
        
    }
}
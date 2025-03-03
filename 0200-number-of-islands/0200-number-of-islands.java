class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, count, m, n);
                }
            }
        }

        return count;
    }

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private void bfs(int i, int j, char[][] grid, int count, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '0';

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == '1') {
                    q.offer(new int[]{newx, newy});
                    grid[newx][newy] = '0';
                }
            }
        }
    }
}
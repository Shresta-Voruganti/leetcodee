class Solution {
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxfish = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0) {
                    maxfish = Math.max(maxfish, bfs(grid, i, j , m, n));
                }
            }
        }
        return maxfish;
    }

    private int bfs(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int fishCount = grid[i][j];
        grid[i][j] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] > 0) {
                    fishCount += grid[newx][newy];
                    q.offer(new int[]{newx, newy});
                    grid[newx][newy] = 0;
                }
            }
        }
        return fishCount;
    }
}

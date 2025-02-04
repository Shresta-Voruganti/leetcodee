class Solution {
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxfish = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0) {
                    maxfish = Math.max(maxfish, dfs(grid, i, j , m, n));
                }
            }
        }
        return maxfish;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int fishCount = grid[i][j];
        grid[i][j] = 0;

        for(int[] dir : dirs) {
            fishCount += dfs(grid, i + dir[0], j + dir[1], m, n);
        }

        return fishCount;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int curr = 0;
        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    curr = bfs(grid, i, j);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int k, int l) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, l});
        int res = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            res++;
            final int[][] neigs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int[] neig : neigs) {
                int i = curr[0] + neig[0];
                int j = curr[1] + neig[1];

                while(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        return res;
    }
}
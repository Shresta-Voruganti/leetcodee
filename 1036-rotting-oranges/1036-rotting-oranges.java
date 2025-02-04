class Solution {
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int orangesRotting(int[][] grid) {
        int time = 0; //to rot all oranges
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0; 

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        while(!q.isEmpty()) {
            int qsize = q.size();
            boolean isRotted = false;

            for(int i = 0; i < qsize; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    while(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                        grid[newx][newy] = 2;
                        q.offer(new int[]{newx, newy});
                        freshCount--;
                        isRotted = true;
                    }
                }
            }
            if(isRotted) {
                time++;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}
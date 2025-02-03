class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
                else {
                    height[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for(int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                while(newx >= 0 && newx < m && newy >= 0 && newy < n && height[newx][newy] == -1) {
                    height[newx][newy] = height[x][y] + 1;
                    q.offer(new int[]{newx, newy});
                }
            }
        }
        return height;
    }
}
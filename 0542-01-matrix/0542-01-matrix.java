class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] newmat = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    newmat[i][j] = -1; //marking unvisited for cells with '1'
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                while(newx >= 0 && newx < m && newy >= 0 && newy < n && newmat[newx][newy] == -1) {
                    newmat[newx][newy] = newmat[x][y] + 1;
                    q.offer(new int[]{newx, newy});
                }
            }
        }
        return newmat;
    }
}
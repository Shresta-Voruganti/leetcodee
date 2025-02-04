class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1}); //row,col,distance, (0,0) it is 0,0,1 because, 
       // (0,0) is the position and 1 is the distance, initially we make that distance 1 at (0,0) itself

        grid[0][0] = 1;
        // and then as we say it is visited, we mark it(starting cell) as visited denoting the value with '1'

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if(row == n-1 && col == n-1) {
                return distance;
            }

            for(int i=-1; i<=1; i++) {
                for(int j=-1; j<=1; j++) {
                    // Skip the case where both i and j are 0 (the current cell itself)
                    if(i==0 && j==0) {
                        continue;
                    }
                    int newrow = row + i;
                    int newcol = col + j;

                    if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && grid[newrow][newcol] == 0) {
                        q.offer(new int[]{newrow, newcol, distance+1});
                        grid[newrow][newcol] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1 , 0}
        };
        int numRows = grid.length;
        int numCols = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0}); // add initial position (0,0), with cost = 0, (row, col, cost)
        int[][] mincost = new int[numRows][numCols];
        for(int i = 0; i < numRows; i++) {
            Arrays.fill(mincost[i], Integer.MAX_VALUE);
        }
        mincost[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(mincost[row][col] != cost) {
                continue;
            }

            for(int dir = 0; dir < dirs.length; dir++) {
                int newrow = row + dirs[dir][0];
                int newcol = col + dirs[dir][1];

                if(newrow >= 0 && newrow < numRows && newcol >= 0 && newcol < numCols) {
                    int newcost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);
                    if(newcost < mincost[newrow][newcol]) {
                        mincost[newrow][newcol] = newcost;
                        pq.offer(new int[] {newrow, newcol, newcost});
                    }
                }
            }
        }
        return mincost[numRows - 1][numCols - 1];
    }
}
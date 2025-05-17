class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int rowHits = 0;
        int[] colHits = new int[cols];
        int max = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for(int k = j; k < cols && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') {
                            rowHits++;
                        }
                    }
                }
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for(int k = i; k < rows && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') {
                            colHits[j]++;
                        }
                    }
                }

                if(grid[i][j] == '0') {
                    max = Math.max(max, rowHits + colHits[j]);
                }
            }
        }

        return max;
    }
}
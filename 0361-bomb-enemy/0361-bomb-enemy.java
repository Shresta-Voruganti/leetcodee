class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '0') {
                    int val = traverse(grid, i, j, rows, cols);
                    max = Math.max(max, val);
                }
            }
        }

        return max;
    }

    private int traverse(char[][] grid, int i, int j, int rows, int cols) {
        int kills = 0;

        for(int x = j - 1; x >= 0 && grid[i][x] != 'W'; x--) {
            if(grid[i][x] == 'E') {
                kills++;
            }
        }

        for(int x = j + 1; x < cols && grid[i][x] != 'W'; x++) {
            if(grid[i][x] == 'E') {
                kills++;
            }
        }

        for(int y = i - 1; y >= 0 && grid[y][j] != 'W'; y--) {
            if(grid[y][j] == 'E') {
                kills++;
            }
        }

        for(int y = i + 1; y < rows && grid[y][j] != 'W'; y++) {
            if(grid[y][j] == 'E') {
                kills++;
            }
        }

        return kills;
    }
}
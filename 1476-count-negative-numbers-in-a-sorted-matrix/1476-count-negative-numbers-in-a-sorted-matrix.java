class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        int col = grid[0].length-1;
        int counter = 0;
        while(row < rows && col >= 0) {
            if(grid[row][col] >= 0) {
                row++;
            }
            else {
                counter += rows-row;
                col--;
            }
        }
        return counter;
    }
}
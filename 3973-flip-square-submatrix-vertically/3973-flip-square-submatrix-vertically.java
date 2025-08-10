class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int j = 0; j < k; j++) {
            int top = x;
            int bottom = x + k - 1;
            while(top < bottom) {
                int temp = grid[top][y + j];
                grid[top][y + j] = grid[bottom][y + j];
                grid[bottom][y + j] = temp;
                top++;
                bottom--;
            }
        }
        return grid;
    }
}
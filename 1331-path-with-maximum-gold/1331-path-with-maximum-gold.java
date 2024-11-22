class Solution {
    public int getMaximumGold(int[][] grid) {
      int maxgold = 0;
      for(int i=0; i<grid.length; i++) {
        for(int j=0; j<grid[0].length; j++) {
            if(grid[i][j]>0) {
                maxgold = Math.max(maxgold, Maxgoldpath(i,j,grid));
            }
        }
      }
      return maxgold;  
    }

    private int Maxgoldpath(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) {
            return 0;
        }
        int currgold = grid[i][j];
        grid[i][j] = 0;
        int maxgold = 0;
        maxgold = Math.max(maxgold, Maxgoldpath(i+1,j,grid));
        maxgold = Math.max(maxgold, Maxgoldpath(i-1,j,grid));
        maxgold = Math.max(maxgold, Maxgoldpath(i,j-1,grid));
        maxgold = Math.max(maxgold, Maxgoldpath(i,j+1,grid));

        grid[i][j] = currgold;

        return currgold+maxgold;
    }
}
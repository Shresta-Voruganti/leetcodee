class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d : dp) {
            Arrays.fill(d, 1);
        }

        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
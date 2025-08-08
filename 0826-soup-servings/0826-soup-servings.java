class Solution {
    private double[][] dp;
    private final int[][] moves = new int[][] {
        {4, 0},
        {3, 1},
        {2, 2},
        {1, 3}
    };
    public double soupServings(int n) {
        if(n >= 4800) return 1.0;

        int units = (n + 24) / 25;
        dp = new double[units + 1][units + 1];
        for(double[] row : dp) {
            Arrays.fill(row, -1.0);
        }
        return dfs(units, units);
    }

    private double dfs(int a, int b) {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0;

        if(dp[a][b] >= 0) return dp[a][b];

        double res = 0.0;
        for(int[] mv : moves) {
            int na = a - mv[0];
            int nb = b - mv[1];
            res += 0.25 * dfs(na, nb);
        }

        dp[a][b] = res;
        return res;
    }
}
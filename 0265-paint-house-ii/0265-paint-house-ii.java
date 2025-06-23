class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        if(n == 0) {
            return 0;
        }

        int[][] dp = new int[n][k];

        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k; j++) {
                dp[i][j] = costs[i][j] + calcMin(dp, i -1, j, k);
            }
        }

        return calc(dp, n - 1, k);
    }

    private int calcMin(int[][] dp, int index, int exc, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            if(i != exc) {
                min = Math.min(dp[index][i], min);
            }
        }
        return min;
    }

    private int calc(int[][] dp, int index, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            min = Math.min(dp[index][i], min);
        }
        return min;
    }
}
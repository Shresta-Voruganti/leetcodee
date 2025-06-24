class Solution {
    int n1;
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }
        n1 = n;

        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minStepsHelper(1, 0, dp);
    }

    private int minStepsHelper(int curr, int paste, int[][] dp) {
        if(curr == n1) {
            return 0;
        }
        if(curr > n1) {
            return 1000;
        }

        if(dp[curr][paste] != -1) {
            return dp[curr][paste];
        }

        int res = Integer.MAX_VALUE;
        if(paste > 0) {
            res = Math.min(res, 1 + minStepsHelper(curr + paste, paste, dp));
        }

        // int op1 = 1 + minStepsHelper(curr + paste, paste, dp);
        // int op2 = 2 + minStepsHelper(curr * 2, curr, dp);

        res = Math.min(res, 2 + minStepsHelper(curr * 2, curr, dp));

        dp[curr][paste] = res;
        return dp[curr][paste];
    }
}
class Solution {
    public int numSquares(int n) {
        if(isPerfectSquare(n)) return 1;

        int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
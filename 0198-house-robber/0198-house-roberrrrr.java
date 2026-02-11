class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // int[] dp = new int[n];
        // dp[0] = nums[0];
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i < n; i++) {
            int take = nums[i];
            if(i > 1) {
                take += prev2;
            }
            int not_take = 0 + prev;
            // dp[i] = Math.max(take, not_take);
            int curi = Math.max(take, not_take);
            prev2 = prev;
            prev = curi;
        }
        // return dp[n - 1];
        return prev;
    }
}

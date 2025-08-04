class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums[0] >= n - 1) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            if(!dp[i]) continue;

            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < n) {
                    dp[i + j] = true;
                }
            }
        }
        
        return dp[n - 1];
    }
}
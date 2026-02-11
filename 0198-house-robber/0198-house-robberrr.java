// Recursion Tree with memoization
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[100];

        Arrays.fill(memo, -1);

        return robFrom(0, nums, memo);
    }

    private int robFrom(int i, int[] nums, int[] memo) {
        if(i >= nums.length) {
            return 0;
        }

        if(memo[i] > -1) {
            return memo[i];
        }

        int ans = Math.max(robFrom(i + 1, nums, memo), robFrom(i + 2, nums, memo) + nums[i]);

        memo[i] = ans;
        return ans;
    }
}

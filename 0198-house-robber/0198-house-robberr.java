// Dynamic Programming
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] maxrobbedAmount = new int[n + 1];

        maxrobbedAmount[n] = 0;
        maxrobbedAmount[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            maxrobbedAmount[i] = Math.max(maxrobbedAmount[i + 1], maxrobbedAmount[i + 2] + nums[i]);
        }

        return maxrobbedAmount[0];
    }
}

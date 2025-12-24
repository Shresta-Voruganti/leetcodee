class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for(int i= 0, j = 0; i < n & j < n * 2; i++, j+=2) {
            ans[j] = nums[i];
        }
        for(int i = n, j = 1; i < 2 * n & j < 2 * n; i++, j+=2) {
            ans[j] = nums[i];
        }
        return ans;
    }
}
class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 1; i < n - 1; i++) {
            if(nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                res = res + 1;
            }
        }
        return res;
    }
}
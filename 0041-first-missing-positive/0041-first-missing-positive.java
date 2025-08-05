class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] exist = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] <= n) {
                exist[nums[i]] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(!exist[i]) {
                return i;
            }
        }
        return n + 1;
    }
}
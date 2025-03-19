class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i <= n - 3; i++) {
            if(nums[i] == 0) {
                flip(nums, i);
                count++;
            }
        }

        for(int num : nums) {
            if(num == 0) {
                return -1;
            }
        }

        return count;
    }

    private void flip(int[] nums, int start) {
        for(int i = start; i < start+3; i++) {
            nums[i] = 1 - nums[i];
        }
    }
}
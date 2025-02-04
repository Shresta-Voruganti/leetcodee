class Solution {
    public int maxAscendingSum(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int sum1 = nums[0];
        int sum2 = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                sum1 = sum1 + nums[i];
            }
            else {
                sum1 = nums[i];
                sum2 = nums[i - 1];
            }
            sum = Math.max(sum, Math.max(sum1, sum2));
        }
        return sum;
    }
}
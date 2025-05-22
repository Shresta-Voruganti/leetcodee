class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int bal = -1;
        int leftSum = 0;
        for(int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) {
                bal = i;
                break;
            }
            leftSum += nums[i];
        }
        return bal;
    }
}

class Solution {
    public int waysToSplitArray(int[] nums) {
        long leftsum = 0;
        long rightsum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            rightsum += nums[i];
        }

        int count = 0;
        for(int i=0; i<n-1; i++) {
            leftsum += nums[i];
            rightsum -= nums[i];

            if(leftsum >= rightsum) {
                count++;
            }
        }
        return count;
    }
}
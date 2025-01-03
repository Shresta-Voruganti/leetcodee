class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixsum = new long[n];
        prefixsum[0] = nums[0];

        for(int i=1; i<n; i++) {
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }

        int count = 0;
        for(int i=0; i<n-1; i++) {
            long leftsum = prefixsum[i];
            long rightsum = prefixsum[n-1] - prefixsum[i];

            if(leftsum >= rightsum) {
                count++;
            }
        }
        return count;
    }
}

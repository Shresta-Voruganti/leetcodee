class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int rem = 0;
        for(int num : nums) {
            if(num != 0) {
                rem++;
            }
        }
        if(rem == 0) {
            return 0;
        }

        for(int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];
            int val = queries[k][2];

            for(int i = l; i <= r; i++) {
                if(nums[i] == 0) continue;
                int dec = Math.min(val, nums[i]);
                nums[i] -= dec;
                if(nums[i] == 0) rem--;
            }

            if(rem == 0) return k + 1;
        }

        return -1;
    }
}

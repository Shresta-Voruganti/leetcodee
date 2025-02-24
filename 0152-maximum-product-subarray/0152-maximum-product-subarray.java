class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int maxprod = nums[0];
        int minprod = nums[0];
        int result = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int temp = maxprod;
                maxprod = minprod;
                minprod = temp;
            }

            maxprod = Math.max(nums[i], maxprod * nums[i]);
            minprod = Math.min(nums[i], minprod * nums[i]);

            result = Math.max(result, maxprod);
        }

        return result;
    }
}
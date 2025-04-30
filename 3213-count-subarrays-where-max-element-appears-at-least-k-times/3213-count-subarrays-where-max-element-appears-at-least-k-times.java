class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = maxArray(nums);
        int left = 0;
        int count = 0;
        long numSub = 0;
        for(int right = 0; right < n; right++) {
            if(nums[right] == max) {
                count++;
            }

            while(count >= k) {
                numSub += n - right;
                if(nums[left] == max) {
                    count--;
                }
                left++;
            }
        }
        return numSub;
    }

    private int maxArray(int[] nums) {
        int maxele = Integer.MIN_VALUE;
        for(int num : nums) {
            maxele = Math.max(num, maxele);
        }
        return maxele;
    }
}
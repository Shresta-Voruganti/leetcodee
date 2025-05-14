class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        if(missingUntil(nums, n - 1) < k) {
            return nums[n - 1] + k - missingUntil(nums, n - 1);
        }

        int low = 0;
        int high = n - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(missingUntil(nums, mid) < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return nums[low - 1] + k - missingUntil(nums, low - 1);
        
    }

    private int missingUntil(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
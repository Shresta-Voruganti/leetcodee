class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        // int sum = 0;
        for(int i = 0; i < n; i++) {
            // sum = nums[i];
            // if(sum == k) {
            //     count++;
            //     break;
            // }
            int sum = 0;
            // for(int j = i + 1; j < n; j++)
            for(int j = i; j < n; j++) {
                sum += nums[j];
                // if(sum > k) {
                //     sum -= nums[j];
                //     break;
                // }
                // else {
                //     count++;
                // }
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
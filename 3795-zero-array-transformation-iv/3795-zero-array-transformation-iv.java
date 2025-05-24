class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;
        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(canZero(nums, queries, mid)) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            List<Integer> vals = new ArrayList<>();
            for(int j = 0; j < k; j++) {
                int l = queries[j][0];
                int r = queries[j][1];
                int val = queries[j][2];
                if(l <= i && i <= r) {
                    vals.add(val);
                }
            }

            if(!canFormSum(vals, nums[i])) {
                return false;
            }  
        }
        return true;
    }

    private boolean canFormSum(List<Integer> vals, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int val : vals) {
            for(int j = target; j >= val; j--) {
                dp[j] = dp[j] || dp[j - val];
            }
        }

        return dp[target];
    }

}
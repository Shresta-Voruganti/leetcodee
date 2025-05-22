class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canZero(nums, queries, mid)) {
                ans = mid;
                right = mid - 1; // try fewer queries
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] dec = new long[n + 2]; // difference array (use long to avoid overflow)

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            dec[l] += val;
            dec[r + 1] -= val;
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += dec[i];
            if (nums[i] > sum) {
                return false;
            }
        }

        return true;
    }
}

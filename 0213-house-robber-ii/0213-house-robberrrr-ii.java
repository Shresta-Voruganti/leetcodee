class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i != 0) {
                temp1.add(nums[i]);
            }
            if(i != (n - 1)) {
                temp2.add(nums[i]);
            }
        }

        int max = Math.max(rob1(temp1.stream().mapToInt(i -> i).toArray()), rob1(temp2.stream().mapToInt(i -> i).toArray()));
        return max;
    }

    private int rob1(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return arr[0];
        }
        int[] dp = new int[n];
        
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++) {
            int take = arr[i] + dp[i - 2];
            int not_take = dp[i - 1];
            dp[i] = Math.max(take, not_take);
        }
        return dp[n - 1];
    }
}

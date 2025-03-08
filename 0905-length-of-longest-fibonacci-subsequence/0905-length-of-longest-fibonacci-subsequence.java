class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if(n < 3) {
            return 0;
        }
        int maxlen = 0;
        int[][] dp = new int[n][n];
        
        for(int curr = 2; curr < n; curr++) {
            int start = 0;
            int end = curr - 1;
            while(start < end) {
                int sum = arr[start] + arr[end];
                if(sum > arr[curr]) {
                    end--;
                }
                else if(sum < arr[curr]) {
                    start++;
                }
                else {
                    dp[end][curr] = dp[start][end] + 1;
                    maxlen = Math.max(maxlen, dp[end][curr]);
                    start++;
                    end--;
                }
            }
        }

        return maxlen != 0 ? maxlen + 2 : 0;
    }
}
class Solution {
    public int numOfSubarrays(int[] arr) {
        // int MOD = 1000000007L;
        int MOD = (int) Math.pow(10, 9) + 7;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            arr[i] = arr[i] & 1;
        }
        int[] dpEven = new int[n];
        int[] dpOdd = new int[n];

        if(arr[n - 1] == 0) {
            dpEven[n - 1] = 1;
        }
        else {
            dpOdd[n - 1] = 1;
        }

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] == 1) {
                dpOdd[i] = (1 + dpEven[i + 1]) % MOD;
                dpEven[i] = dpOdd[i + 1];
            }
            else {
                dpEven[i] = (1 + dpEven[i + 1]) % MOD;
                dpOdd[i] = dpOdd[i + 1];
            }
        }

        int count = 0;
        for(int odd : dpOdd) {
            count += odd;
            count %= MOD;
        }

        return count;
    }
}

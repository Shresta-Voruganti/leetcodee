class Solution {
    public int[] closestPrimes(int left, int right) {
        // int[] ans = new int[2];
        int[] ans = {-1, -1};

        List<Integer> res = new ArrayList<>();

        boolean[] isPrime = sieve(right);
        // while(left <= right) {
        //     if(isPrime(left)) {
        //         res.add(left);
        //     }
        //     left++;
        // }

        for(int i = Math.max(2, left); i <= right; i++) {
            if(isPrime[i]) {
                res.add(i);
            }
        }
        int n = res.size();
        if(n <= 1) {
            // Arrays.fill(ans, -1);
            return ans;
        }
        
        int num1;
        int num2;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            num1 = res.get(i);
            num2 = res.get(i + 1);
            if(num2 - num1 < diff) {
                diff = num2 - num1;
                ans[0] = num1;
                ans[1] = num2;
            }

        }

        return ans;
    }

    // private boolean isPrime(int n) {
    //     if (n <= 1) return false;
    //     for (int i = 2; i <= Math.sqrt(n); i++) {
    //         if (n % i == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        // isPrime[0] = false; isPrime[1] = false;
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
        
    }
}
class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[2];
        List<Integer> res = new ArrayList<>();
        int num1;
        int num2;
        while(left <= right) {
            if(isPrime(left)) {
                res.add(left);
            }
            left++;
        }
        int n = res.size();
        if(n <= 1) {
            Arrays.fill(ans, -1);
            return ans;
        }
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

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
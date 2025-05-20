class Solution {
    public final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenCount = n / 2 + (n % 2 == 0 ? 0 : 1);
        long oddCount = n/2;

        long evenChoices = power(5, evenCount);
        long oddChoices = power(4, oddCount);

        return (int) (evenChoices * oddChoices % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        base = base % MOD;
        while(exp > 0) {
            if(exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}
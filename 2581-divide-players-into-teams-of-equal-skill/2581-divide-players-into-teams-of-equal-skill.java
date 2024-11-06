class Solution {
    public long dividePlayers(int[] skill) {
        long chem = 0;
        int[] sk = skill.clone();
        Arrays.sort(sk);
        int n = sk.length;
        // Calculate the target sum of each pair
        int targetSum = sk[0] + sk[n - 1];
        for (int i = 0; i < n / 2; i++) {
            int k = n - i - 1;
            // Check if the current pair sums up to the target sum
            if (sk[i] + sk[k] != targetSum) {
                return -1; // Return -1 if any pair doesn't meet the target sum
            }
            // Calculate and accumulate the chemistry for each pair
            chem += (long) sk[i] * sk[k];
        }
        return chem;
    }
}

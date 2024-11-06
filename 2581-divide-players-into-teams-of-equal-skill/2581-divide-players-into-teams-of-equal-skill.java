class Solution {
    public long dividePlayers(int[] skill) {
        long chem = 0;  // Set to 0 instead of -1
        int[] sk = skill.clone();
        Arrays.sort(sk);
        int n = sk.length;
        int targetSum = sk[0] + sk[n - 1];  // Expected sum for each pair
        ArrayList<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            int k = n - i - 1;
            // Check if the current pair sums up to the target sum
            if (sk[i] + sk[k] != targetSum) {
                return -1;
            }
            // Add the pair to pairs list and compute the chemistry
            pairs.add(new int[]{sk[i], sk[k]});
            chem += (long) sk[i] * sk[k];  // Sum of products for the chemistry value
        }
        return chem;
    }
}

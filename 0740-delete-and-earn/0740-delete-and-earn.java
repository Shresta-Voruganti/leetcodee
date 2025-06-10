class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxele = 0;
        int sum = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int le : nums) {
            maxele = Math.max(maxele, le);
            sum += le;
            hmap.put(le, hmap.getOrDefault(le, 0) + 1);
        }
        int[] dp = new int[maxele + 1];
        dp[0] = 0;
        dp[1] = 1 * hmap.getOrDefault(1, 0);

        for(int i = 2; i < maxele + 1; i++) {
            int isum = i * hmap.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + isum);
        }

        return dp[maxele];
    }
}
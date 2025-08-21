class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        return dp(n);
    }

    private int dp(int i) {
        if(i <= 2) return i;

        if(!memo.containsKey(i)) {
            memo.put(i, dp(i - 1) + dp(i - 2));
        }

        return memo.get(i);
    }
}

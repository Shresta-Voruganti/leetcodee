class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(m - 1, n - 1, word1.toCharArray(), word2.toCharArray(), dp);
    }

    private int f(int i, int j, char[] s1, char[] s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1[i] == s2[j]) return dp[i][j] = 0 + f(i - 1, j - 1, s1, s2, dp);
        else {
            return dp[i][j] = Math.min(
                1 + f(i - 1, j - 1, s1, s2, dp), Math.min(
                    1 + f(i, j - 1, s1, s2, dp),
                    1 + f(i - 1, j, s1, s2, dp)
                )
            );
            // return dp[i][j] = 1 + Math.min(
            //     f(i - 1, j - 1, s1, s2, dp), Math.min(
            //         f(i, j - 1, s1, s2, dp),
            //         f(i - 1, j, s1, s2, dp)
            //     )
            // );
        }
    }
}
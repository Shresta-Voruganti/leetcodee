class Solution {
    private int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length + 1][m + 1][n + 1];
        for(int[][] l : dp) {
            for(int[] r : l) {
                Arrays.fill(r, -1);
            }
        }
        return calc(m, n, strs, 0);
    }

    private int calc(int cm, int cn, String[] strs, int ind) {
        if(ind == strs.length) {
            return 0;
        }

        if(dp[ind][cm][cn] != -1) {
            return dp[ind][cm][cn];
        }

        int z = co0(strs[ind]);
        int o = co1(strs[ind]);

        int not_take = calc(cm, cn, strs, ind + 1);
        int take = 0;

        if(z <= cm && o <= cn) {
            take = 1 + calc(cm - z, cn - o, strs, ind + 1); 
        }

        int res = Math.max(take, not_take);
        dp[ind][cm][cn] = res;
        return res;
    }

    private int co1(String s) {
        int c = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                c++;
            }
        }
        return c;
    }

    private int co0(String s) {
        int c = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                c++;
            }
        }
        return c;
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] x = text1.toCharArray();
        char[] y = text2.toCharArray();
        int m = x.length;
        int n = y.length;
        int[][] l = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i==0 || j==0) {
                    l[i][j] = 0;
                }
                else if(x[i-1] == y[j-1]) {
                    l[i][j] = l[i-1][j-1] + 1;
                }
                else {
                    l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
                }
            }
        }
        return l[m][n];
    }
}
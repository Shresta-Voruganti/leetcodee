class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k2 = mat2.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < k2; j++) {
                for(int k = 0; k < n; k++) {
                    res[i][k] += mat1[i][j] * mat2[j][k];
                }
            }
        }
        return res;
    }
}
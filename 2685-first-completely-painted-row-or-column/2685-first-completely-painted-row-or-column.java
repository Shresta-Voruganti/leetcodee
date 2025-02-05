class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> pos = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                pos.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int i = 0; i < arr.length; i++) {
            int[] curr = pos.get(arr[i]);
            int row = curr[0], col = curr[1];

            rowCount[row]++;
            colCount[col]++;

            if(rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }
        return -1;
    }
}
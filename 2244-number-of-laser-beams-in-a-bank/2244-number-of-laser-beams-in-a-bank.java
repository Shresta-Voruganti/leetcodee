class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int[][] mat = new int[m][n];
        boolean[] rows = new boolean[m];
        int count = 0;
        Arrays.fill(rows, false);
        for(int i = 0; i < m; i++) {
            String row = bank[i];
            if(row.contains(String.valueOf('1'))) rows[i] = true;
            // if(row.indexOf('1') != -1) rows[i] = true;
            for(int j = 0; j < n; j++) {
                mat[i][j] = row.charAt(j) - '0';
            }
        }
        for(int i = 0; i < m; i++) {
            if(rows[i]) {
                int nextrow = -1;
                for(int k = i + 1; k < m; k++) {
                    if(rows[k]) {
                        nextrow = k;
                        break;
                    }
                }
                if(nextrow == -1) continue;
                for(int j = 0; j < n; j++) {
                    if(mat[i][j] == 1) {
                        for(int l = 0; l < n; l++) {
                            if(mat[nextrow][l] == 1) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
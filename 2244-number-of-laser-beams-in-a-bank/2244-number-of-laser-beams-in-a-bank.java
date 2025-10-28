class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int[] rowones = new int[m];
        boolean[] rows = new boolean[m];
        int count = 0;

        for(int i = 0; i < m; i++) {
            int ones = 0;
            for(int j = 0; j < n; j++) {
                if(bank[i].charAt(j) == '1') ones++;
            }
            rowones[i] = ones;
            rows[i] = ones > 0;
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
                count += (rowones[i] * rowones[nextrow]);
            }
        }

        return count;
    }
}
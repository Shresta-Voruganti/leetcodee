class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> ht = new HashMap<>();
        for(int i = 1; i <= n*n; i++) {
            ht.put(i, 0);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ht.put(grid[i][j], ht.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int[] ans = new int[2];
        for(Map.Entry<Integer, Integer> e : ht.entrySet()) {
            if(e.getValue() == 0) {
                ans[1] = e.getKey();
            }
            if(e.getValue() == 2) {
                ans[0] = e.getKey();
            }
        }

        return ans;
    }
}
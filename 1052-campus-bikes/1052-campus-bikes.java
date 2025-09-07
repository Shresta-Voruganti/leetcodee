class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        boolean[] vis = new boolean[m];

        List<int[]> pairs = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pairs.add(new int[]{dist, i, j});
            }
        }

        Collections.sort(pairs, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int assigned = 0;

        for(int[] pair : pairs) {
            int i = pair[1];
            int j = pair[2];

            if(ans[i] == -1 && !vis[j]) {
                ans[i] = j;
                vis[j] = true;
                assigned++;
            }

            if(assigned == n) {
                break;
            }
        }

        return ans;
    }
}
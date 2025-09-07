class Solution {
    private int ans = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        boolean[] vis = new boolean[m];
        backtrack(0, workers, bikes, vis, 0);
        return ans;
    }

    private void backtrack(int sum, int[][] workers, int[][] bikes, boolean[] vis, int i) {
        if(i == workers.length) {
            ans = Math.min(ans, sum);
            return;
        }
        // if(vis[j]) {
        //     return;
        // }
        // vis[j] = true;
        // sum += Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
        // backtrack(sum, workers, bikes, vis, ans, i + 1, j + 1);
        
        // vis[j] = false;

        for(int j = 0; j < bikes.length; j++) {
            if(!vis[j]) {
                vis[j] = true;
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                backtrack(sum + dist, workers, bikes, vis, i + 1);
                vis[j] = false;
            }
        }
        return;
    }
}
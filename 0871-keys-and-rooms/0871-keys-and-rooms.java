class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(0, vis, rooms);

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, boolean[] vis, List<List<Integer>> rooms) {
        vis[room] = true;
        for(int key : rooms.get(room)) {
            if(!vis[key]) {
                dfs(key, vis, rooms);
            }
        }
    }
}
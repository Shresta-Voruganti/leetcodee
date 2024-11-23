class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int provinces = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int current) {
        visited[current] = true;
        for(int neighbour = 0; neighbour<visited.length; neighbour++) {
            if(isConnected[current][neighbour] == 1 && !visited[neighbour]) {
                dfs(isConnected, visited, neighbour);
            }
        }
    }
}
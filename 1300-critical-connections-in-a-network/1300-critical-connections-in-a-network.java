class Solution {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new List[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> criticalConn = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, -1, vis, tin, low, adj, criticalConn);
            }
        }

        return criticalConn;
    }

    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, List<Integer>[] adj, List<List<Integer>> criticalConn) {
        vis[node] = true;
        tin[node] = low[node] = time++;

        for(int neig : adj[node]) {
            if(neig == parent) {
                continue;
            }

            if(!vis[neig]) {
                dfs(neig, node, vis, tin, low, adj, criticalConn);
                low[node] = Math.min(low[node], low[neig]);

                if(low[neig] > tin[node]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(neig);
                    criticalConn.add(bridge);
                }
            }
            else {
                low[node] = Math.min(low[node], tin[neig]);
            }
        }
    }
}
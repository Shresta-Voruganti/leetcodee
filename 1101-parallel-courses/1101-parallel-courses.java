class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        for (int[] rel : relations) {
            int u = rel[0];
            int v = rel[1];
            adj[u].add(v); 
            indegree[v]++;   
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;
        int sems = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int node = q.poll();
                completed++;

                
                for (int neighbor : adj[node]) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
            sems++;
        }

        return completed == n ? sems : -1;
    }
}
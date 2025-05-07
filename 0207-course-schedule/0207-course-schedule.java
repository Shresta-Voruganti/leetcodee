class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            completed++;

            for(int neig : adj[node]) {
                indegree[neig]--;
                if(indegree[neig] == 0) {
                    q.add(neig);
                }
            }
        }

        return completed == numCourses;
    }
}
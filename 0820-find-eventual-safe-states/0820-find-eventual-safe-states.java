class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];
        for(int u = 0; u < graph.length; u++) {
            for(int v : graph[u]) {
                adjRev.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            
            for(int neig : adjRev.get(node)) {
                indegree[neig]--;
                if(indegree[neig] == 0) {
                    q.add(neig);
                }
            }
        }

        Collections.sort(topo);
        return topo;
    }
}
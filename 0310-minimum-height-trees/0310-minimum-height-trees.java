class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return List.of(0);
        }
        List<Set<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for(int leaf : leaves) {
                int neig = adj.get(leaf).iterator().next();
                adj.get(neig).remove(leaf);
                if(adj.get(neig).size() == 1) {
                    newLeaves.add(neig);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
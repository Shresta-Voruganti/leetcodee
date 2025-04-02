class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if(n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int steps = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int index = q.poll();

                if(index == n - 1) {
                    return steps;
                }

                if(index + 1 < n && !vis[index + 1]) {
                    q.add(index + 1);
                    vis[index + 1] = true;
                }

                if(index - 1 >= 0 && !vis[index - 1]) {
                    q.add(index - 1);
                    vis[index - 1] = true;
                }

                if(graph.containsKey(arr[index])) {
                    for(int j : graph.get(arr[index])) {
                        if(!vis[j]) {
                            q.add(j);
                            vis[j] = true;
                        }
                    }

                    graph.remove(arr[index]);
                }
            }
            steps++;
        }

        return steps;
    }
}
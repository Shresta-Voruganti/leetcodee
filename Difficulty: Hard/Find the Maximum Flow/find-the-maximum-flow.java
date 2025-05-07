//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


// User function Template for Java
class Solution {
    int V;
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // code here
        this.V = N;
        int[][] graph = new int[V + 1][V + 1];
        
        for(ArrayList<Integer> edge : Edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int capacity = edge.get(2);
            graph[u][v] += capacity;
            graph[v][u] += capacity;
        }
        
        int s = 1;
        int t = N;
        
        int u, v;
        int[][] rgraph = new int[V + 1][V + 1];

        for(u = 1; u <= V; u++) {
            for(v = 1; v <= V; v++) {
                rgraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V + 1];
        int maxflow = 0;

        // while(dfs(rgraph, s, t, parent)) 
        while(bfs(rgraph, s, t, parent))
        // while (bfs1(rgraph, s, t, parent, new boolean[V + 1]))
        // while (dfs1(rgraph, s, t, parent, new boolean[V + 1])) 
        {
            int pathflow = Integer.MAX_VALUE;
            for(v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathflow = Math.min(pathflow, rgraph[u][v]);
            }

            for(v = t; v != s; v = parent[v]) {
                u = parent[v];
                rgraph[u][v] -= pathflow;
                rgraph[v][u] += pathflow;
            }
            maxflow += pathflow;
        }
        return maxflow;
    }
    
    // Iterative DFS
    // public boolean dfs(int[][] rgraph, int s, int t, int[] parent) {
    //     boolean[] vis = new boolean[V + 1];
    //     Stack<Integer> stk = new Stack<>();
    //     stk.push(s);
    //     vis[s] = true;
    //     parent[s] = -1;

    //     while(!stk.isEmpty()) {
    //         int u = stk.pop();
    //         for(int v = 1; v <= V; v++) {
    //             if(!vis[v] && rgraph[u][v] > 0) {
    //                 parent[v] = u;
    //                 vis[v] = true;
    //                 if(v == t) {
    //                     return true;
    //                 }
    //                 stk.push(v);
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    // Iterative BFS
    public boolean bfs(int[][] rgraph, int s, int t, int[] parent) {
        boolean[] vis = new boolean[V + 1]; 
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        vis[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            // System.out.println("Visiting node: " + u);
            for (int v = 1; v <= V; v++) {
                if (!vis[v] && rgraph[u][v] > 0) {  
                    parent[v] = u;
                    vis[v] = true;
                    if (v == t) {
                        // System.out.println("Path found from " + s + " to " + t);
                        return true;
                    }
                    q.offer(v);
                }
            }
        }
        return false;
    }
    
    // Recursive DFS
    public boolean dfs1(int[][] rgraph, int u, int t, int[] parent, boolean[] vis) {
        vis[u] = true;

        // If we've reached the target node
        if (u == t) {
            return true;
        }

        // Explore neighbors recursively
        for (int v = 1; v <= V; v++) {
            if (!vis[v] && rgraph[u][v] > 0) {
                parent[v] = u;
                if (dfs1(rgraph, v, t, parent, vis)) {
                    return true;
                }
            }
        }

        return false;  // No path found
    }
    
    // Recursive BFS
    // public boolean bfs1(int[][] rgraph, int u, int t, int[] parent, boolean[] vis) {
    //     vis[u] = true;

    //     // If we've reached the target node
    //     if (u == t) {
    //         return true;
    //     }

    //     // Explore neighbors recursively
    //     for (int v = 1; v <= V; v++) {
    //         if (!vis[v] && rgraph[u][v] > 0) {
    //             parent[v] = u;
    //             if (bfs1(rgraph, v, t, parent, vis)) {
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;  // No path found
    // }
}

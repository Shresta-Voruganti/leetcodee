//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int time = 0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] mark = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            if(mark[i]) {
                ans.add(i);
            }
        }
        
        if(ans.size() == 0) {
            // return {-1};
            ans.add(-1);
        }
        
        return ans;
    }
    
    private static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, boolean[] mark, List<Integer>[] adj) {
        vis[node] = true;
        tin[node] = low[node] = time++;
        
        int child = 0;
        
        for(int neig : adj[node]) {
            if(neig == parent) {
                continue;
            }
            
            if(!vis[neig]) {
                dfs(neig, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[neig]);
                
                if(low[neig] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[neig]);
            }
        }
        
        if(child > 1 && parent == -1) {
            mark[node] = true;
        }
    }
}
//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Priority Queue to select the edge with the smallest weight
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        
        // Visited array to track included nodes in MST
        boolean[] vis = new boolean[V];  
        pq.add(new int[]{0, 0});  // Start from node 0 with weight 0

        int sum = 0;  // To store the total weight of the MST
        int nodesInMST = 0; // Track the number of nodes added to the MST
        
        while (!pq.isEmpty() && nodesInMST < V) {
            int[] edge = pq.poll();
            int node = edge[0];
            int weight = edge[1];

            // If the node is already visited, skip it
            if (vis[node]) continue;

            // Mark the node as visited and add its weight to the MST sum
            vis[node] = true;
            sum += weight;
            nodesInMST++;

            // Traverse all adjacent nodes of the current node
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                // If the adjacent node has not been visited, add it to the priority queue
                if (!vis[adjNode]) {
                    pq.add(new int[]{adjNode, edgeWeight});
                }
            }
        }
        return sum;
    }
}

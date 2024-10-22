//minimum spanning tree - using prim's algorithm with min heap (priority queue)

import java.util.*;

class Triplet {
    int weight;
    int node;
    int parent;
    public Triplet(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

class sp-mst {
    public int MST(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((x,y) -> x.weight-y.weight);
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        pq.add(new Triplet(0,0,-1));
        int sum = 0;
        List<int[]> mst = new ArrayList<>();
        while(pq.size()>0) {
            Triplet current = pq.poll();
            int wt = current.weight;
            int node = current.node;
            int parent = current.parent;

            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            if(parent!=-1) {
                mst.add(new int[]{wt,node,parent});
            }

            for(ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edW = edge.get(1);
                if(vis[adjNode] == 0)
                {
                    pq.add(new Triplet(edW,adjNode,node));
                }
            }
        }

        System.out.println("Edge : Weight");
        for(int[] edge : mst) {
            System.out.println(edge[2]+" - "+edge[1]+" : "+edge[0]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number vertices");
        int V = sc.nextInt();
        System.out.println("enter number of rows");
        int rows = sc.nextInt();
        System.out.println("enter number of columns");
        int cols = sc.nextInt();
        System.out.println("adjacency matrix");
        int[][] adjmatrix = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                adjmatrix[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(adjmatrix[i][j]!=0) {
                    adj.get(i).add(new ArrayList<>(Arrays.asList(j, adjmatrix[i][j])));
                }
            }
        }
        sp-mst pp = new sp-mst();
        int sum = pp.MST(V,adj);
        System.out.println("mst weight : " + sum);
        sc.close();
    }
}

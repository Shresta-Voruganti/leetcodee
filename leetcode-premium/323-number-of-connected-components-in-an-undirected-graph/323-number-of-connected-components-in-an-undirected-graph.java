public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        DisjointSet dsu = new DisjointSet(n);
        int counter = n;
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int fx = dsu.findParent(x);
            int fy = dsu.findParent(y);
            if(fx != fy) {
                counter--;
                dsu.union(fx, fy);
            }
        }
        return counter;
    }
}

class DisjointSet {
    int n;
    int[] parent, rank;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        makeset();
    }

    public void makeset() {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findParent(int x) {
        if(x != parent[x]) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if(px == py) {
            return;
        }
        if(rank[px] > rank[py]) {
            parent[py] = px;
//            parent[py] = parent[px];
        }
        else if(rank[px] < rank[py]) {
            parent[px] = py;
//            parent[px] = parent[py];
        }
        else {
            parent[py] = px;
//            parent[py] = parent[px];
            rank[px] = rank[px] + 1;
        }
    }
}

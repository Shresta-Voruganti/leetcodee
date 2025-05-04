class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet dsu = new DisjointSet(n + 1);

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = dsu.findParent(u);
            int pv = dsu.findParent(v);
            if(dsu.union(pu, pv)) {
                return new int[]{u, v};
            }
        }
        return new int[0];
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

    public boolean union(int x, int y) {
        int fx = findParent(x);
        int fy = findParent(y);

        if(fx == fy) {
            return true;
        }

        if(rank[fx] > rank[fy]) {
            parent[fy] = fx;
            return false;
        }
        else if(rank[fx] < rank[fy]) {
            parent[fx] = fy;
            return false;
        }
        else {
            parent[fy] = fx;
            rank[fx] = rank[fx] + 1;
            return false;
        }
    }
}
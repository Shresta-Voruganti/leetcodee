class Solution {
    static int[][] dirs = {{0, -1}, {-1, 0}};
    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        DisjointSet dsu = new DisjointSet(row * col);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int index = i * col + j;

                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x >= 0 && x < row && y >= 0 && y < col && grid[i][j] == grid[x][y]) {
                        int newindex = x * col + y;
                        if (dsu.findParent(index) == dsu.findParent(newindex)) {
                            return true;
                        }

                        dsu.union(index, newindex);
                    }
                }
            }
        }
        return false;
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
            rank[i] = 0;
        }
    }

    public int findParent(int x) {
        if(x != parent[x]) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if(px == py) {
            return true;
        }

        if(rank[px] > rank[py]) {
            parent[py] = px;
        }
        else if(rank[px] < rank[py]) {
            parent[px] = py;
        }
        else {
            parent[py] = px;
            rank[px] = rank[px] + 1;
        }
        return false;
    }
}
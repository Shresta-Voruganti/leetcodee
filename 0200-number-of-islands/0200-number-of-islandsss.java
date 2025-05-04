class Solution {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DisjointSet dsu = new DisjointSet(row, col);

        for(int i = 0; i < row * col; i++) {
            dsu.parent[i] = i;
            dsu.sz[i] = 1;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    int index = i * col + j;
                    for(int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int newindex = x * col + y;
                            dsu.union(index, newindex);
                        }
                    }
                }
            }
        }

        Set<Integer> hs = new HashSet<>();

        for(int i = 0; i < row * col; i++) {
            if(grid[i / col][i % col] == '1') {
                hs.add(dsu.findParent(i));
            }
        }

        return hs.size();
    }
}

class DisjointSet {
    int rows, cols;
    int[] parent, sz;

    public DisjointSet(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        parent = new int[rows * cols];
        sz = new int[rows * cols];
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
        if(sz[px] >= sz[py]) {
            parent[py] = px;
            sz[px] += py;
        }
        else {
            parent[px] = py;
            sz[py] += sz[px];
        }
    }
}

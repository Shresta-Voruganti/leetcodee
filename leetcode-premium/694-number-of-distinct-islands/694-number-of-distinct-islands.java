public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */

    static int[] dRow = {0, -1, 1, 0};
    static int[] dCol = {1, 0, 0, -1};

    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        int row = grid.length;
        int col = grid[0].length;
        DisjointSet dsu = new DisjointSet(row, col);

        for(int i = 0; i < row * col; i++) {
            dsu.parent[i] = i;
            dsu.sz[i] = 1;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    int curIndex = i * col + j;
                    for(int k = 0; k < 4; k++) {
                        int x = i + dRow[k];
                        int y = j + dCol[k];
                        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                            int neigIndex = x * col + y;
                            dsu.union(curIndex, neigIndex);
                        }
                    }
                }
            }
        }

        String[] pattern = new String[row * col];
        Arrays.fill(pattern, "");

        for(int i = 0; i < row * col; i++) {
            if(grid[i / col][i % col] == 1) {
                int parentIndex = dsu.findParent(i);
                pattern[parentIndex] += String.valueOf(i - parentIndex);
            }
        }

        Set<String> hs = new HashSet<>();
        for(String p : pattern) {
            if(!p.isEmpty()) {
                hs.add(p);
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
            sz[px] += sz[py];
        }
        else {
            parent[px] = py;
            sz[py] += sz[px];
        }
    }
}

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, shape);
                    shapes.add(String.join(",", shape));
                }
            }
        }

        return shapes.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseI, int baseJ, List<String> shape) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        shape.add((i - baseI) + ":" + (j - baseJ)); // relative position from start of island

        dfs(grid, visited, i + 1, j, baseI, baseJ, shape);
        dfs(grid, visited, i - 1, j, baseI, baseJ, shape);
        dfs(grid, visited, i, j + 1, baseI, baseJ, shape);
        dfs(grid, visited, i, j - 1, baseI, baseJ, shape);
    }
}

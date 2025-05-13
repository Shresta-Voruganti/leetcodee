class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] position, int[] destination, boolean[][] visited) {
        if(visited[position[0]][position[1]]) {
            return false;
        }
        if(position[0] == destination[0] && position[1] == destination[1]) {
            return true;
        }
        visited[position[0]][position[1]] = true;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs) {
            int x = position[0];
            int y = position[1];

            while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }

            if(dfs(maze, new int[]{x - dir[0], y - dir[1]}, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
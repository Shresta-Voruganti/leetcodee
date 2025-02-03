class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        for(int i = 0; i < numCourses; i++) {
            Arrays.fill(isReachable[i], false);
        }

        for(int[] pre : prerequisites) {
            isReachable[pre[0]][pre[1]] = true;
        }

        for(int k = 0; k < numCourses; k++) {
            for(int i = 0; i < numCourses; i++) {
                for(int j = 0; j < numCourses; j++) {
                    if(isReachable[i][k] && isReachable[k][j]) {
                        isReachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(isReachable[query[0]][query[1]]);
        }
        return res;
    }
}
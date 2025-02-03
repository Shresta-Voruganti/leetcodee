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
        for(int[] qq : queries) {
            res.add(isReachable[qq[0]][qq[1]]);
        }
        return res;
    }
}
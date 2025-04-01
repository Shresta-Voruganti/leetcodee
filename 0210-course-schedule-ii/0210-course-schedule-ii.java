class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] dep : prerequisites) {
            int course = dep[0];
            int prereq = dep[1];
            graph[prereq].add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            result.add(course);

            for(int nextCourse : graph[course]) {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0) {
                    q.add(nextCourse);
                }
            }
        }

        if(result.size() != numCourses) {
            return new int[0];
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
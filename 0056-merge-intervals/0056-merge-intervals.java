class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

        int[] cur = intervals[0];
        for(int i = 1; i < n; i++) {
            int[] next = intervals[i];

            if(next[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], next[1]);
            }
            else {
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);

        // int n1 = res.size();
        // int[][] res1 = new int[n1][2];
        // for(int i = 0; i < n1; i++) {
        //     int[] q = res.get(i);
        //     res1[i][0] = q[0];
        //     res1[i][1] = q[1];
        // }
        // return res1;

        return res.toArray(new int[res.size()][]);
    }
}
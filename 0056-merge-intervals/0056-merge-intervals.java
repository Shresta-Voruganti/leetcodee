class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        int[] current = intervals[0];
        for(int i = 1; i < n; i++) {
            int[] next = intervals[i];

            if(next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            }
            else {
                res.add(current);
                current = next;
            }
        }
        res.add(current);

        return res.toArray(new int[res.size()][]);
    }
}
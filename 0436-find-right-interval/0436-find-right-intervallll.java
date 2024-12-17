class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            int mindiff = Integer.MAX_VALUE;
            int index = -1;
            for(int j=0; j<n; j++) {
                if(intervals[j][0] >= intervals[i][1]) {
                    int diff = intervals[j][0] - intervals[i][1];
                    if(diff < mindiff) {
                        mindiff = diff;
                        index = j;
                    }
                }
            }
            res[i] = index;
        }
        return res;
    }
}

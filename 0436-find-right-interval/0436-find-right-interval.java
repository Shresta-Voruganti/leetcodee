class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];

        int[][] indexedintervals = new int[n][3];
        for(int i=0; i<n; i++) {
            indexedintervals[i][0] = intervals[i][0];
            indexedintervals[i][1] = intervals[i][1];
            indexedintervals[i][2] = i;
        }

        Arrays.sort(indexedintervals, (a,b) -> Integer.compare(a[0],b[0]));

        for(int i=0; i<n; i++) {
            int end = intervals[i][1];
            int left = 0;
            int right = n-1;
            int index = -1;
            while(left<=right) {
                int mid = left + (right-left)/2;
                if(indexedintervals[mid][0] >= end) {
                    index = indexedintervals[mid][2];
                    right = mid-1; //to get small start
                }                
                else {
                    left = mid+1; //to move right
                }
            }
            res[i] = index;
        }
        return res;
    }
}
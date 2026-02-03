class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        int l = toBeRemoved[0];
        int r = toBeRemoved[1];

        for(int[] curr : intervals) {
            int a = curr[0];
            int b = curr[1];

            if(l >= b || r <= a) {
                res.add(Arrays.asList(a, b));
            }
            else {
                if(l > a) {
                    res.add(Arrays.asList(a, l));
                }
                if(r < b) {
                    res.add(Arrays.asList(r, b));
                }
            }
        }
        return res;
    }
}
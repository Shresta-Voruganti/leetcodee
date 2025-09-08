class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxdist = 0;
        int globalmin = arrays.get(0).get(0);
        int globalmax = arrays.get(0).get(arrays.get(0).size() - 1);

        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int curmin = curr.get(0);
            int curmax = curr.get(curr.size() - 1);

            int dist1 = Math.abs(globalmax - curmin);
            int dist2 = Math.abs(curmax - globalmin);

            maxdist = Math.max(maxdist, Math.max(dist1, dist2));

            globalmax = Math.max(globalmax, curmax);
            globalmin = Math.min(globalmin, curmin);
        }   

        return maxdist;
    }
}
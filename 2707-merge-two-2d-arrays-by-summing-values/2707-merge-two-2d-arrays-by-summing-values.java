class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> hmap = new TreeMap<>();
        int m1 = nums1.length;
        int m2 = nums2.length;
        for(int i = 0; i < m1; i++) {
            hmap.put(nums1[i][0], nums1[i][1]);
        }

        for(int i = 0; i < m2; i++) {
            hmap.put(nums2[i][0], hmap.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        int[][] res = new int[hmap.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            res[index][0] = e.getKey();
            res[index][1] = e.getValue();
            index++;
        }

        return res;
    }
}
class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] mapping = new int[n];
        for(int i = 0; i < n; i++) {
            int ele = nums1[i];
            for(int j = 0; j < n; j++) {
                if(nums2[j] == ele) {
                    mapping[i] = j;
                }
            }
        }
        return mapping;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> hmap = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            }
        }
        int n = 1;
        for(int key : hmap.keySet()) {
            if(n != key) {
                return n;
            }
            else {
                n++;
            }
        }
        return n;
    }
}
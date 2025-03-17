class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            if((e.getValue() & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}
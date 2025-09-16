class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        if(hmap.getOrDefault(target, 0) > n/2) return true;
        return false;
    }
}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(nums[i])) {
                // Check if the duplicate is within distance k
                if (i - hmap.get(nums[i]) <= k) {
                    return true;
                }
            }
            
            // Update the index of the current number
            hmap.put(nums[i], i);
        }
        
        return false;
    }
}
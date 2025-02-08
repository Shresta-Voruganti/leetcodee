class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set1 = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set1.contains(nums[i])) {
                return true;
            }
            set1.add(nums[i]);

            if(set1.size() > k) {
                set1.remove(nums[i - k]);
            }
        }

        return false;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>(); // value -> index
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hmap.containsKey(complement)) {
                return new int[]{hmap.get(complement), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{};
    }
}
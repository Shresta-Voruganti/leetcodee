class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int need = target - nums[i];

            if(hmap.containsKey(need)) {
                return new int[]{hmap.get(need), i};
            }

            hmap.put(nums[i], i);
        }   

        return new int[]{-1, -1};
    }
}
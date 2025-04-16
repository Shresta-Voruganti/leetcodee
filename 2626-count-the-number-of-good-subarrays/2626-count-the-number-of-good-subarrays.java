class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int same = 0;
        int right = -1;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int left = 0; left < n; left++) {
            while(same < k && right + 1 < n) {
                ++right;
                same += hmap.getOrDefault(nums[right], 0);
                hmap.put(nums[right], hmap.getOrDefault(nums[right], 0) + 1);
            }
            if(same >= k) {
                count += n - right;
            }
            hmap.put(nums[left], hmap.get(nums[left]) - 1);
            same -= hmap.get(nums[left]);
        }

        return count;
    }
}
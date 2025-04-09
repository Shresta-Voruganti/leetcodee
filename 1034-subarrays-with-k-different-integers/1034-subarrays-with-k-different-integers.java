class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtmostKDistinct(nums, k) - countAtmostKDistinct(nums, k - 1);
    }

    private int countAtmostKDistinct(int[] nums, int k) {
        int left = 0;
        int result = 0;
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int right = 0; right < nums.length; right++) {
            if(hmap.getOrDefault(nums[right], 0) == 0) {
                k--;
            }
            hmap.put(nums[right], hmap.getOrDefault(nums[right], 0) + 1);

            while(k < 0) {
                hmap.put(nums[left], hmap.get(nums[left]) - 1);
                if(hmap.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            result += right - left + 1;
        }

        return result;
    }
}
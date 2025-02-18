class Solution {
    public long countBadPairs(int[] nums) {
        long totalPairs = ((long) nums.length * (nums.length - 1)) / 2;
        long goodPairs = 0;
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i] - i;
            if(hmap.containsKey(num)) {
                goodPairs += hmap.get(num);
            }
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}
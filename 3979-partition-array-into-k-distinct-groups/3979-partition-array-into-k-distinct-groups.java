class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;

        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        
        int groups = n / k;

        for(int count : hmap.values()) {
            if(count > groups) {
                return false;
            }
        }
        return true;
    }
}
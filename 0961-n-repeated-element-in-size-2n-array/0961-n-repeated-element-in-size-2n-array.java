class Solution {
    public int repeatedNTimes(int[] nums) {
        int l = nums.length;
        int n = l/2;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int d : nums) {
            hmap.put(d, hmap.getOrDefault(d, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            if(v == n) return k;
        }
        return -1;
    }
}
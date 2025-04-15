class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int op = 0;

        for(int num : nums) {
            int comp = k - num;
            if(hmap.getOrDefault(comp, 0) > 0) {
                op++;
                hmap.put(comp, hmap.get(comp) - 1);
            }
            else {
                hmap.put(num, hmap.getOrDefault(num, 0) + 1);
            }
        }

        return op;
    }
}
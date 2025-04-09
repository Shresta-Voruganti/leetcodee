class Solution {
    public int minOperations(int[] nums, int k) {
        int op = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        } 
        // for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
        //     if(e.getKey() < k) {
        //         op = -1;
        //         return op;
        //     }
        //     else if(e.getKey() > k) {
        //         op++;
        //     }
        // }
        for(Integer key : hmap.keySet()) {
            if(key < k) {
                op = -1;
                return op;
            }
            else if(key > k) {
                op++;
            }
        }
        return op;
    }
}
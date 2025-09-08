class Solution {
    public int largestUniqueNumber(int[] nums) {
        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        for(int d : nums) {
            hmap.put(d, hmap.getOrDefault(d, 0) + 1);
        }
        NavigableMap<Integer, Integer> map2 = hmap.descendingMap();

        for(Map.Entry<Integer, Integer> e : map2.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if(val == 1) {
                return key;
            }
        }
        return -1;
    }
}
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        Set<Integer> hset = new HashSet<>();
        for(int num : arr) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        for(int num : hmap.values()) {
            if(hset.contains(num)) {
                return false;
            }
            hset.add(num);
        }
        return true;
    }
}
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        Set<Integer> hset = new HashSet<>();
        for(int num : arr) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        for(int num : hmap.values()) {
            hset.add(num);
        }
        return hmap.size() == hset.size();
    }
}
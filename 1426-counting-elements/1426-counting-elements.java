class Solution {
    public int countElements(int[] arr) {
        Set<Integer> hset = new HashSet<>();
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int d : arr) {
            hset.add(d);
            hmap.put(d, hmap.getOrDefault(d, 0) + 1);
        }
        int count = 0;
        for(Integer val : hset) {
            if(hset.contains(val + 1)) {
                count += hmap.get(val);
            }
        }
        return count;
    }
}
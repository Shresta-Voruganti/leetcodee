class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int val : hmap.values()) {
            if(val % 2 == 0 && val < min) {
                min = val;
            }
            if(val % 2 == 1 && val > max) {
                max = val;
            }
        }
        int diff = max - min;
        return diff;
    }
}
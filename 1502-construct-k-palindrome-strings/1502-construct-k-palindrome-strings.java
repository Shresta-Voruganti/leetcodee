class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) {
            return false;
        }
        Map<Character, Integer> checkht = new HashMap<>();
        for(char ch : s.toCharArray()) {
            checkht.put(ch, checkht.getOrDefault(ch, 0) + 1);
        }
        int counts = 0;
        for(int val : checkht.values()) {
            if(val % 2 == 1) {
                counts++;
            }
        }
        if(counts > k) {
            return false;
        }
        else {
            return true;
        }
    }
}
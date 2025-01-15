class Solution {
    public boolean canConstruct(String s, int k) {
        // If the s.length < k we cannot construct k strings from s and answer is false.
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
        // If the number of characters that have odd counts is > k then the minimum number of palindrome strings we can construct is > k and answer is false.
        if(counts > k) {
            return false;
        }
        // Otherwise you can construct exactly k palindrome strings and answer is true.
        else {
            return true;
        }
    }
}
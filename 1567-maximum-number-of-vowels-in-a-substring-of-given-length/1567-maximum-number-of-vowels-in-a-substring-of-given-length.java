class Solution {
    static Set<Character> hset = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        int n = s.length();
        for(int i = 0; i < k; i++) {
            if(hset.contains(s.charAt(i))) {
                count++;
            }
        }
        max = Math.max(count, max);
        if(max == k) return max;

        for(int i = k; i < n; i++) {
            if(hset.contains(s.charAt(i - k))) count--;
            if(hset.contains(s.charAt(i))) count++;
            max = Math.max(count, max);
            if(max == k) return max;
        }

        return max;
    }
}
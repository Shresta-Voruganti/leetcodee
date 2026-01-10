class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxlen = 0;
        int left = 0;
        int len = s.length();
        Map<Character, Integer> hmap = new HashMap<>();
        for(int right = 0; right < len; right++) {
            hmap.put(s.charAt(right), hmap.getOrDefault(s.charAt(right), 0) + 1);
            if(hmap.size() > k) {
                left++;
                char ch = s.charAt(left - 1);
                if (hmap.get(ch) == 1) {
                    hmap.remove(ch);
                } 
                else {
                    hmap.put(ch, hmap.get(ch) - 1);
                }
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}
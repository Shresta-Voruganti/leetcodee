class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        int left = 0;
        int right = 0;

        int res = 0;
        while(right < s.length()) {
            char chr = s.charAt(right);
            hmap.put(chr, hmap.getOrDefault(chr, 0) + 1);

            while(hmap.get(chr) > 1) {
                char chl = s.charAt(left);
                hmap.put(chl, hmap.get(chl) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) {
            return 0;
        }
        int count = 0;
        int k = 3;
        Map<Character, Integer> hmap = new HashMap<>();

        for(int i = 0; i < k; i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(hmap.size() == k) {
            count++;
        }

        for(int i = k; i < s.length(); i++) {
            char outEle = s.charAt(i - k);
            if(hmap.get(outEle) == 1) {
                hmap.remove(outEle);
            }
            else {
                hmap.put(outEle, hmap.get(outEle) - 1);
            }
            char inEle = s.charAt(i);
            hmap.put(inEle, hmap.getOrDefault(inEle, 0) + 1);

            if(hmap.size() == k) {
                count++;
            }
        }
        return count;
    }
}
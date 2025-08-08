class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();

        Map<Character, Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> smap = new HashMap<>();
        int l = 0, r = 0;
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        int have = 0;
        int need = tmap.size();

        while(r < m) {
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if(tmap.containsKey(ch) && smap.get(ch).intValue() == tmap.get(ch).intValue()) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < minlen) {
                    minlen = r - l + 1;
                    start = l;
                }
                char leftchar = s.charAt(l);
                smap.put(leftchar, smap.get(leftchar) - 1);

                if(tmap.containsKey(leftchar) && smap.get(leftchar) < tmap.get(leftchar)) {
                    have--;
                }
                l++;
            }
            r++;
        }

        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
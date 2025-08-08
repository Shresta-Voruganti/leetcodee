class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(n > m) return "";

        Map<Character, Integer> hmap2 = new HashMap<>();
        for(char ch : t.toCharArray()) {
            hmap2.put(ch, hmap2.getOrDefault(ch, 0) + 1);
        }
        int reslen = Integer.MAX_VALUE;

        Map<Character, Integer> hmap1 = new HashMap<>();
        int have = 0;
        int need = hmap2.size();
        int l = 0;
        int r = 0;
        int start = 0;

        while(r < m) {
            char ch = s.charAt(r);
            hmap1.put(ch, hmap1.getOrDefault(ch, 0) + 1);
            if(hmap2.containsKey(ch) && hmap1.get(ch).intValue() == hmap2.get(ch).intValue()) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < reslen) {
                    reslen = r - l + 1;
                    start = l;
                }

                char leftchar = s.charAt(l);
                hmap1.put(leftchar, hmap1.get(leftchar) - 1);
                if(hmap2.containsKey(leftchar) && hmap1.get(leftchar) < hmap2.get(leftchar)) {
                    have--;
                }
                l++;
            }
            r++;
        }

        return reslen == Integer.MAX_VALUE ? "" : s.substring(start, start + reslen);

        // for(int i = 0; i < m; i++) {
        //     for(int j = n + i - 1; j < m; j++) {
        //         String sub = s.substring(i, j + 1);
        //         Map<Character, Integer> hmap1 = new TreeMap<>();
        //         for(char ch : sub.toCharArray()) {
        //             hmap1.put(ch, hmap1.getOrDefault(ch, 0) + 1);
        //         }
        //         boolean alltrue = true;
                
        //         for(Map.Entry<Character, Integer> e : hmap2.entrySet()) {
        //             char key = e.getKey();
        //             int val = e.getValue();
        //             if(!hmap1.containsKey(key) || hmap1.get(key) < val) {
        //                 alltrue = false;
        //                 break;
        //             }
        //         }
        //         if(alltrue) {
        //             int len = sub.length();
        //             if(len <= reslen) {
        //                 res = sub;
        //                 reslen = len;
        //             }
        //         }

        //         // hmap1.clear();
        //     }
        // }

        // return res.isEmpty() ? "" : res;
    }
}
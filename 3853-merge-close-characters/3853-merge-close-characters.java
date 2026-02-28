class Solution {
    public String mergeCharacters(String s, int k) {
        char[] sa = s.toCharArray();
        Map<Character, Integer> hmap = new HashMap<>();
        for(char ch : sa) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        if(hmap.size() == 0) {
            return s;
        }
        List<Character> dups = new ArrayList<>();
        for(Map.Entry<Character, Integer> e : hmap.entrySet()) {
            dups.add(e.getKey());
        }
        StringBuilder sb = new StringBuilder(s);

        boolean merged = true;
        
        while(merged) {
            merged = false;
            int newi1 = -1;
            int newi2 = -1;
            char newch = ' ';
            for(char ch : dups) {
                if(!hmap.containsKey(ch) || hmap.get(ch) < 2) {
                    continue;
                }
                int prevind = -1;
                for(int i = 0; i < sb.length(); i++) {
                    if(sb.charAt(i) == ch) {
                        if(prevind != -1 && i - prevind <= k) {
                            if(newi1 == -1 || prevind < newi1 || (prevind == newi1 && i < newi2)) {
                                newi1 = prevind;
                                newi2 = i;
                                newch = ch;
                            }
                            break;
                        }
                        prevind = i;
                    }
                }
            }
            if(newi1 != -1) {
                sb.deleteCharAt(newi2);
                merged = true;
                if(hmap.get(newch) > 1) {
                    hmap.put(newch, hmap.get(newch) - 1);
                }
                else {
                    hmap.remove(newch);
                }
            }
        }
        return sb.toString();
    }
}
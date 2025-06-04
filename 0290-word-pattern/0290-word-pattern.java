class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hmap = new HashMap<>();
        char[] charArr = pattern.toCharArray();
        Set<String> used = new HashSet<>();
        int nc = charArr.length;
        int ns = s.length();
        int i;
        int j = 0;
        for(i = 0; i < nc; i++) {
            while(j < ns && s.charAt(j) == ' ') {
                j++;
            }
            if(j >= ns) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            while(j < ns && s.charAt(j) != ' ') {
                sb.append(s.charAt(j));
                j++;
            }
            String sq = sb.toString();
            if(!hmap.containsKey(charArr[i])) {
                if(used.contains(sq)) {
                    return false;
                }
                hmap.put(charArr[i], sq);
                used.add(sq);
            }
            else {
                String val = hmap.get(charArr[i]);
                if(!val.equals(sq)) {
                    return false;
                }
            }
        }  
        while(j < ns && s.charAt(j) == ' ') {
            j++;
        } 
        return j == ns;
    }
}
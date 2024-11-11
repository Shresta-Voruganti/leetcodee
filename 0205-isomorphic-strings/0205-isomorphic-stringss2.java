class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            
            if(mapST.containsKey(chS)) {
                if(mapST.get(chS) != chT) {
                    return false; // s -> t mapping does not match
                }
            } else {
                mapST.put(chS, chT);
            }
            
            if(mapTS.containsKey(chT)) {
                if(mapTS.get(chT) != chS) {
                    return false; // t -> s mapping does not match
                }
            } else {
                mapTS.put(chT, chS);
            }
        }
        
        return true;
    }
}

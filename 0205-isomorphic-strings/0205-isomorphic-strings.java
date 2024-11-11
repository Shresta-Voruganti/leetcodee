class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            
            if (sMap[chS] != tMap[chT]) {
                return false;
            }
            
            sMap[chS] = i + 1;
            tMap[chT] = i + 1;
        }
        
        return true;
    }
}

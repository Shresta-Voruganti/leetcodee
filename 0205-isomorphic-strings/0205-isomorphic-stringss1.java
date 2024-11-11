class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        HashMap<Character,Character> mst = new HashMap<>();
        HashMap<Character,Character> mts = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(mst.containsKey(s.charAt(i))) {
                if(mst.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                }
            }
            else {
                mst.put(s.charAt(i),t.charAt(i));
            }
            if(mts.containsKey(t.charAt(i))) {
                if(mts.get(t.charAt(i))!=s.charAt(i)) {
                    return false;
                }
            }
            else {
                mts.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}

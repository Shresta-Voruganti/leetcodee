class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        int n = pref.length();

        for(String word : words) {
            if(word.length() >= n) {
                boolean isPrefix = true;
                for(int i = 0; i < n; i++) {
                    if(word.charAt(i) != pref.charAt(i)) {
                        isPrefix = false;
                        break;
                    }
                }
                if(isPrefix) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
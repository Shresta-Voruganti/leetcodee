class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return new String("");
        if(s.length() == 1) return s;
        int maxlen = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if(checkpal(sub)) {
                    int len = sub.length();
                    if(len > maxlen) {
                        maxlen = len;
                        res = sub;
                    } 
                }
            }
        }
        if(res.equals("")) return String.valueOf(s.charAt(0));
        return res;
    }

    private boolean checkpal(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
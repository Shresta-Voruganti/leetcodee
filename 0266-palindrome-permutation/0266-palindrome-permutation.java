class Solution {
    public boolean canPermutePalindrome(String s) {
        int bm = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            int val = s.charAt(i) - 'a';
            bm = bm ^ (1 << val);
        }

        if((bm == 0) || (((bm) & (bm - 1)) == 0)) {
            return true;
        }

        return false;
    }
}
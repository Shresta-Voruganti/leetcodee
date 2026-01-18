class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n - k + 1; i++) {
            String sub = s.substring(i, i + k);
            if(hasNoRepeat(sub)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasNoRepeat(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] > 1) return false;
        }
        return true;
    }
}
class Solution {
    public int nextBeautifulNumber(int n) {
        int num = -1;
        for(int i = n + 1; ; i++) {
            if(isBalanced(i)) {
                num = i;
                break;
            }
        }
        return num;
    }

    private boolean isBalanced(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] freq = new int[10];
        
        for(int i = 0; i < len; i++) {
            freq[s.charAt(i) - '0']++;
        }

        for(int d = 0; d < 10; d++) {
            if(freq[d] > 0 && freq[d] != d) return false;
        }
        return true;
    }
}
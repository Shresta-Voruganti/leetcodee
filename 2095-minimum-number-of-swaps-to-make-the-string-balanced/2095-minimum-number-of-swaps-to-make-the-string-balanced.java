class Solution {
    public int minSwaps(String s) {
        int swaps = 0;
        int n = s.length();
        int openp = 0;
        int closep = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='[') {
                openp++;
            }
            else {
                closep++;
            }

            if(closep>openp) {
                swaps++;
                openp++;
                closep--;
            }
        }
        return swaps;
    }
}
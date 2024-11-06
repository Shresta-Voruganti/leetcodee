class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int n = s.length();
        int openp = 0;
        int closep = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='(') {
                openp++;
            }
            else {
                if(openp>0) {
                    openp--;
                }
                else {
                    closep++;
                }
            }
        }
        count = openp+closep;
        return count;
    }
}
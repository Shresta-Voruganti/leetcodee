class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        res.append(ch);
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == ch) {
                count++;
            }
            else {
                ch = s.charAt(i);
                count = 1;
            }
            if(count<=2) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
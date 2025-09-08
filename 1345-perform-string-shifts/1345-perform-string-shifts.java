class Solution {
    public String stringShift(String s, int[][] shift) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int[] sh : shift) {
            int dir = sh[0];
            int am = sh[1];
            for(int i = 0; i < am; i++) {
                if(dir == 0) {
                    char ch = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(ch);
                }
                else {
                    char ch = sb.charAt(sb.length() - 1);
                    // sb.delete(sb.length() - 1, sb.length());
                    sb.deleteCharAt(sb.length() - 1);
                    sb.insert(0, ch);
                }
            }
        }
        return sb.toString();
    }
}
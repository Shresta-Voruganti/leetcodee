public class Solution {
    /**
     * @param s: a string
     * @param dict: a list of strings
     * @return: return a string
     */
    public String addBoldTag(String s, String[] dict) {
        // write your code here
        boolean[] bold = new boolean[s.length()];

        for(String word : dict) {
            int start = s.indexOf(word);
            while(start != -1) {
                for(int i = start; i < word.length() + start; i++) {
                    bold[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < s.length()) {
            if(bold[i]) {
                sb.append("<b>");
                while(i < s.length() && bold[i]) {
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");
            }
            else {
                sb.append(s.charAt(i++));
            }
        }
        
        return sb.toString();
    }
}

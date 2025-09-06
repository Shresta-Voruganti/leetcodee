class Solution {
    public String boldWords(String[] words, String s) {
        int n = s.length();
        boolean[] bold = new boolean[n];

        for(String word : words) {
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
        while(i < n) {
            if(bold[i]) {
                sb.append("<b>");
                while(i < n && bold[i]) {
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
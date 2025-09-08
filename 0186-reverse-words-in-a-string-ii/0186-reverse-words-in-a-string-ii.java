class Solution {
    public void reverseWords(char[] s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                res.add(sb.toString());
                res.add(" ");
                sb.setLength(0);
            }
            else {
                sb.append(s[i]);
            }
        }
        res.add(sb.toString());

        Collections.reverse(res);
        int i = 0;
        for(String word : res) {
            for(char ch : word.toCharArray()) {
                s[i++] = ch;
            }
        }
    }
}
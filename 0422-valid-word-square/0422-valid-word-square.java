class Solution {
    public boolean validWordSquare(List<String> words) {
        int maxlen = 0;
        for(String word : words) {
            int len = word.length();
            maxlen = Math.max(maxlen, len);
        }
        int n = words.size();
        char[][] matrix = new char[n][maxlen];
        for(int i = 0; i < n; i++) {
            char[] chs = words.get(i).toCharArray();
            for(int j = 0; j < chs.length; j++) {
                matrix[i][j] = chs[j];
            }
        }
        List<String> colwords = new ArrayList<>();
        for(int j = 0; j < maxlen; j++) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(j < words.get(i).length()) {
                    sb.append(matrix[i][j]);
                }
            }
            colwords.add(sb.toString());
        }

        for(int i = 0; i < n; i++) {
            if(!compareWords(words.get(i), colwords.get(i))) return false;
        }
        return true;
    }

    private boolean compareWords(String w1, String w2) {
        return w1.equals(w2);
    }
}
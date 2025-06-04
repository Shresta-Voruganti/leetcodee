class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(String word : words) {
            if(isStrechy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStrechy(String s, String word) {
        int i = 0;
        int j = 0;
        int ns = s.length();
        int nw = word.length();

        while(i < ns && j < nw) {
            if(s.charAt(i) != word.charAt(j)) {
                return false;
            }

            int len1 = 0;
            int len2 = 0;

            while((i + len1) < ns && s.charAt(i + len1) == s.charAt(i)) {
                len1++;
            }
            while((j + len2) < nw && word.charAt(j + len2) == word.charAt(j)) {
                len2++;
            }

            if(len1 < 3 && len1 != len2) {
                return false;
            }
            if(len1 >= 3 && len2 > len1) {
                return false;
            }

            i += len1;
            j += len2;
        }
        return i == ns && j == nw;
    }
}
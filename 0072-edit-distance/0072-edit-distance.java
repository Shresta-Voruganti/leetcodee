class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];
    
        for(int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for(int i = 1; i <= m; i++) {
            cur[0] = i;
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = 0 + prev[j - 1];
                }
                else {
                    cur[j] = 1 + Math.min(prev[j], Math.min(
                        prev[j - 1], cur[j - 1]
                    ));
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[n];
    }
}
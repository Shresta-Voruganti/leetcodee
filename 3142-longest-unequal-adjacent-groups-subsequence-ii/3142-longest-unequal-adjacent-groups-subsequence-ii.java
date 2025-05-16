class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int max = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(hammingDistance(words[i], words[j]) && dp[j] + 1 > dp[i] && groups[i] != groups[j]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
                if(dp[i] > dp[max]) {
                    max = i;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = max; i >= 0; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private boolean hammingDistance(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if(diff > 1) {
                    return false;
                }
                // if(++diff > 1) {
                //     return false;
                // }
            }
        }
        return true;
    }
}
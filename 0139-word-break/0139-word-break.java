class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie tr = new Trie();
        for(String word : wordDict) {
            tr.insert(word);
        }

        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && tr.search(s, j, i)) {
//                if(dp[j] && tr.search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}

class Trie {
    static final int numchars = 26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        boolean isEndofword;

        TrieNode() {
            isEndofword = false;
            for(int i = 0; i < numchars; i++) {
                children[i] = null;
            }
        }
    };

    TrieNode root = new TrieNode();

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode curr = root;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndofword = true;
    }

//    public boolean search(String key) {
//        int level;
//        int length = key.length();
//        int index;
//
//        TrieNode curr = root;
//
//        for(level = 0; level < length; level++) {
//            index = key.charAt(level) - 'a';
//            if(curr.children[index] == null) {
//                return false;
//            }
//            curr = curr.children[index];
//        }
//        return curr.isEndofword;
//    }

    // Optimized search method: directly uses the start and end indices
    public boolean search(String s, int start, int end) {
        TrieNode curr = root;
        for(int i = start; i < end; i++) {
            int index = s.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndofword;
    }
}
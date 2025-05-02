class Solution {
    Trie tr;
    Map<Integer, List<String>> hmap;
    public List<String> wordBreak(String s, List<String> wordDict) {
        tr = new Trie();
        for(String word : wordDict) {
            tr.insert(word);
        }

        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && tr.search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if(dp[length] == false) {
            return new ArrayList<String>();
        }

        hmap = new HashMap<>();
        return dfs(s, 0);
    }

    public List<String> dfs(String s, int start) {
        if(hmap.containsKey(start)) {
            return hmap.get(start);
        }

        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
            return res;
        }

        for(int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if(tr.search(substr)) {
                List<String> subList = dfs(s, end);
                for(String sub : subList) {
                    if(sub.isEmpty()) {
                        res.add(substr);
                    }
                    else {
                        res.add(substr + " " + sub);
                    }
                }
            }
        }

        hmap.put(start, res);
        return res;
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

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode curr = root;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndofword;
    }
}
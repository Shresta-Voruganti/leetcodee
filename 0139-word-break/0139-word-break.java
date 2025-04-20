class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        Trie.root = new Trie.trieNode();
        for(String word : wordDict) {
            t.insert(word);
        }

        Boolean[] canform = new Boolean[s.length()];
        return segment(s, 0, canform);
    }

    private boolean segment(String s, int start, Boolean[] canform) {
        if(start == s.length()) {
            return true;
        }
        if(canform[start] != null) {
            return canform[start];
        }

        Trie.trieNode curr = Trie.root;
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(curr.children[c - 'a'] == null) {
                break; // No path in Trie, so stop
            }
            curr = curr.children[c - 'a'];
            if(curr.isEnd) {
                if(segment(s, i + 1, canform)) {
                    return canform[start] = true;
                }
            }
        }

        return canform[start] = false;

    }
}

class Trie {
    static final int NUM_CHARS = 26;

    static class trieNode {
        trieNode[] children = new trieNode[NUM_CHARS];
        boolean isEnd;

        trieNode() {
            isEnd = false;
            for(int i = 0; i < NUM_CHARS; i++) {
                children[i] = null;
            }
        }
    };

    static trieNode root;

    static void insert(String key) {
        int level;
        int length = key.length();
        int index;
        
        trieNode curr = root;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new trieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }    
}
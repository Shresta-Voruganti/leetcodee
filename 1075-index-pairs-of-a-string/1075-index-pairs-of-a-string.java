class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        Trie tr = new Trie();
        Trie.root = new Trie.TrieNode();
        for(String word : words) {
            tr.insert(word);
        }
//        Trie.TrieNode curr = root;
        int length = text.length();
        for(int i = 0; i < length; i++) {
            Trie.TrieNode curr = Trie.root;
            int j = i;

            while(j < length && curr.children[text.charAt(j) - 'a'] != null) {
                curr = curr.children[text.charAt(j) - 'a'];
                if(curr.isEndofWord) {
                    res.add(new int[]{i, j});
                }
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

class Trie {
    static final int numchars = 26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        boolean isEndofWord;
        TrieNode() {
            isEndofWord = false;
            for(int i = 0; i < numchars; i++) {
                children[i] = null;
            }
        }
    };

    static TrieNode root;

    static void insert(String key) {
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
        curr.isEndofWord = true;
    }
}
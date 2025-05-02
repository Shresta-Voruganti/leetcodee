public class Solution {
    /**
     * @param words: A string array
     * @return: String with all prefixes in words
     */
    public String longestWord(String[] words) {
        // write your code here
        Trie trie = new Trie();
        return trie.longestWord(words);
    }
}

class Trie {
    static final int numchars = 26;

    class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        boolean isEndofword;
        TrieNode() {
            isEndofword = false;
            for (int i = 0; i < numchars; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root = new TrieNode();
    String res = "";

    public void insert(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndofword = true;
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        for (String word : words) {
            searchforword(word);
        }
        return res;
    }

    public void searchforword(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null || !curr.children[index].isEndofword) {
                return;
            }
            curr = curr.children[index];
        }

        if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
            res = word;
        }
    }
}

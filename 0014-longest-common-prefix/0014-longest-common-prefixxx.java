class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie tr = new Trie();
        for(String word : strs) {
            tr.insert(word);
        }
        return tr.longestcommonprefix();
    }
}

class Trie {
    static final int numchars = 26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        boolean isEndofword;
        char ch;

        TrieNode() {
            isEndofword = false;
        }
    };

    TrieNode root = new TrieNode();

    public void insert(String key) {
        TrieNode curr = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
                curr.children[index].ch = key.charAt(level);
            }
            curr = curr.children[index];
        }
        curr.isEndofword = true;
    }

    public String longestcommonprefix() {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        while (true) {
            int count = 0;
            TrieNode next = null;

            for (int i = 0; i < numchars; i++) {
                if (curr.children[i] != null) {
                    count++;
                    next = curr.children[i];
                }
            }

            // If the current node has more than one child or ends a word, stop.
            if (count != 1 || curr.isEndofword) {
                break;
            }

            prefix.append(next.ch);
            curr = next;
        }

        return prefix.toString();
    }
}

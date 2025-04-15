class Trie {
    static final int NUM_CHARS = 26;

    class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }

        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (currentNode.children[index] == null) {
                return false;
            }

            currentNode = currentNode.children[index];
        }

        return currentNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (currentNode.children[index] == null) {
                return false;
            }

            currentNode = currentNode.children[index];
        }

        return true;
    }
}
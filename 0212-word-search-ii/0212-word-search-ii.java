class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie tr = new Trie();
        for(String word : words) {
            tr.insert(word);
        }

        Set<String> result = new HashSet<>();
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", tr.root, vis, result);
            }
        }

        return new ArrayList<>(result);
    }

    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void dfs(char[][] board, int i, int j, String path, Trie.TrieNode curr, boolean[][] vis, Set<String> result) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j]) {
            return;
        }

        char ch = board[i][j];
        Trie.TrieNode next = curr.children[ch - 'a'];
        if(next == null) {
            return;
        }

        path += ch;
        if(next.isEndofword) {
            result.add(path);
        }

        vis[i][j] = true;
        
        for(int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], path, next, vis, result);
        }

        vis[i][j] = false;
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
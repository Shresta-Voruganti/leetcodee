class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Trie tr = new Trie();
        for(String word : words) {
            tr.insert(word);
        }

        PriorityQueue<Trie.TrieNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) return a.str.compareTo(b.str);
            else return b.count - a.count;
        });

        tr.traverse(tr.root, pq);

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty() && k > 0) {
            Trie.TrieNode curr = pq.poll();
            String cur = curr.str;
            res.add(cur);
            k--;
        }

        return res;
    }
}

class Trie {
    static final int numchars = 26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        boolean isEndofword;
        int count;
        String str;

        TrieNode() {
            isEndofword = false;
            count = 0;
            str = "";
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
        curr.count += 1;
        curr.str = key;
    }

    public void traverse(TrieNode root, PriorityQueue<Trie.TrieNode> pq) {
        if(root == null) {
            return;
        }

        if(root.isEndofword) {
            pq.add(root);
        }

        for(int i = 0; i < numchars; i++) {
            traverse(root.children[i], pq);
        }
    }
}
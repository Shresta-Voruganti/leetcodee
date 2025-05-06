class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie tr = new Trie();

        for(int num : nums) {
            tr.insert(num);
        }

        int max = 0;
        for(int num : nums) {
            max = Math.max(max, tr.findMaxXOR(num));
        }

        return max;
    }
}

class Trie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    public void insert(int num) {
        TrieNode curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode curr = root;
        int maxXOR = 0;
        for(int i = 31; i >=0; i--) {
            int bit = (num >> i) & 1;
            int oppbit = 1 - bit;
            if(curr.children[oppbit] != null) {
                maxXOR |= (1 << i);
                curr = curr.children[oppbit];
            }
            else {
                curr = curr.children[bit];
            }
        }
        return maxXOR;
    }
}
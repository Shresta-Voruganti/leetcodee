// class WordFilter {

//     public WordFilter(String[] words) {
        
//     }
    
//     public int f(String pref, String suff) {
        
//     }
// }

class WordFilter {
    static final int numchars = 27;
    static class TrieNode {
        TrieNode[] children = new TrieNode[numchars];
        int weight;

        TrieNode() {
            for(int i = 0; i < numchars; i++) {
                children[i] = null;
            }
        }
    };

    TrieNode root;

    private void insert(String key, int weight) {
        TrieNode curr = root;
        for(char ch : key.toCharArray()) {
            int index = ch == '{' ? 26 : ch - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            curr.weight = weight;
        }
    }

    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int weight = 0; weight < words.length; weight++) {
            String word = words[weight];

            for(int i = 0; i < word.length(); i++) {
                insert(word.substring(i) + '{' + word, weight);
            }
            insert("{" + word, weight);
        }
    }

    public int f(String pref, String suff) {
        String key = suff + '{' + pref;
        TrieNode curr = root;
        for(char ch : key.toCharArray()) {
            int index = ch == '{' ? 26 : ch - 'a';
            if(curr.children[index] == null) {
                return -1;
            }
            curr = curr.children[index];
        }
        return curr.weight;
    }
}


/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
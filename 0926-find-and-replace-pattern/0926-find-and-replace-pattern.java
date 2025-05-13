class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(satisfy(words[i], pattern)) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean satisfy(String word, String pattern) {
        if(word.length()  != pattern.length()) {
            return false;
        }

        return getPattern(word).equals(getPattern(pattern));
    }

    private List<Integer> getPattern(String str) {
        Map<Character, Integer> hmap = new HashMap<>();
        List<Integer> patternn = new ArrayList<>();
        int count = 0;

        for(char c : str.toCharArray()) {
            if(!hmap.containsKey(c)) {
                hmap.put(c, count++);
            }

            patternn.add(hmap.get(c));
        }

        return patternn;
    }
}
class Solution {
    public List<String> stringMatching(String[] words) {
      List<String> res = new ArrayList<>();
      for(int i = 0; i < words.length; i++) {
        for(int j = 0; j < words.length; j++) {
            if(i == j) {
                continue;
            }
            else {
                if(isSubString(words[i], words[j])) {
                    if(!res.contains(words[i])) {
                        res.add(words[i]);
                    }
                }
            }
        }
      }
      return res;
    }

    private boolean isSubString(String word1, String word2) {
        if(word1.length() > word2.length()) {
            return false;
        }

        if(word2.contains(word1)) {
            return true;
        }
        else {
            return false;
        }
    }
}
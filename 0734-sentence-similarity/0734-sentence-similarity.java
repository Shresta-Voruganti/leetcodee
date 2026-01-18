class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n1 = sentence1.length;
        int n2 = sentence2.length;
        boolean samelen = false;
        boolean similar = true;
        if(n1 == n2) samelen = true;
        else return false;

        for(int i = 0; i < n1; i++) {
            similar = false;
            if((sentence1[i]).equals(sentence2[i])) similar = true;
            else {
                // similar = similarPairs.stream().
                //     anyMatch(similarPair -> similarPair.contains(sentence1[i]) && similarPair.contains(sentence2[i]));
                for (List<String> pair : similarPairs) {
                    if (pair.contains(sentence1[i]) && pair.contains(sentence2[i])) {
                        similar = true;
                        break;
                    }
                }
            }

            // if(similar == false) 
            if(!similar) {
                return false;
            }
        }
        return true;
    }
}
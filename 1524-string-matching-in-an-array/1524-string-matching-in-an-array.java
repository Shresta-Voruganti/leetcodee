class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length; j++) {
                if(i == j) {
                    continue;
                }
                if(isSubstringOf(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    private boolean isSubstringOf(String sub, String mainn) {
        for(int i=0; i<mainn.length(); i++) {
            boolean subFits = true;
            for(int j=0; j<sub.length(); j++) {
                if(i+j >= mainn.length() || mainn.charAt(i+j) != sub.charAt(j)) {
                    subFits = false;
                    break;
                }
            }

            if(subFits) {
                return true;
            }
        }
        return false;
    }
}
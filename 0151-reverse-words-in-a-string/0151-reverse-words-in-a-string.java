class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length-1;

        while(left < right) {
            String word = words[left];
            words[left] = words[right];
            words[right] = word;

            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<words.length; i++){
            result.append(words[i]);
            if(i < words.length-1) {
                result.append(" ");
            }
        }
        return result.toString();
        // return String.join(" ", words);
    }
}
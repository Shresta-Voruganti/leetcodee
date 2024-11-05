class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1;
        for(int i=0; i<word.length(); i++) {
            while(i<word.length()-1 && word.charAt(i)==word.charAt(i+1) && count<9) {
                count++;
                i++;
            }
            comp.append(String.valueOf(count)).append(word.charAt(i));
            // comp.append(word.charAt(i));
            count = 1;
        }
        return comp.toString();
    }
}
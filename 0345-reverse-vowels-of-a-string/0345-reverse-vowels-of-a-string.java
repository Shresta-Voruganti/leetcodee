class Solution {
    static List<Character> vowelsList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(!checkVowel(s.charAt(left))) {
                left++;
            }
            else if(!checkVowel(s.charAt(right))) {
                right--;
            }
            else {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);

                left++;
                right--;
            }
        }

        return sb.toString();
    }

    private boolean checkVowel(char ch) {
//        if(vowelsList.contains(ch)) {
//            return true;
//        }
//        return false;
        return vowelsList.contains(ch);
    }
}
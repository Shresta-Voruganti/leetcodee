class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if(i > 0 && Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                int j = i - 1;
                while(j >= 0 && j < sb.length()) {
                    if(Character.isLetter(sb.charAt(j))) {
                        sb.deleteCharAt(j);
                        i--;
                        break;
                    }
                    j--;
                }
            }
            else {
                i++;
            }
        }

        return sb.toString();
    }
}
class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int sign = 1;
        int result = 0;
        boolean numStarted = false;
        boolean signSeen = false;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(!numStarted && !signSeen && ch == ' ') {
                continue;
            }
            if(!numStarted && !signSeen && (ch == '+' || ch == '-')) {
                sign = (ch == '-') ? -1 : 1;
                signSeen = true;
                continue;
            }

            if(Character.isDigit(ch)) {
                numStarted = true;
                int digit = ch - '0';

                if(result > (Integer.MAX_VALUE - digit)/ 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + digit;
            }
            else {
                break;
            }
        }
        return result * sign;
    }
}
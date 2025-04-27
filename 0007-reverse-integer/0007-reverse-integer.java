class Solution {
    public int reverse(int x) {
        int revNum = 0;

        // Integer.MAX_VALUE =  2147483647 → last digit 7.
        // Integer.MIN_VALUE = -2147483648 → last digit -8.

        while(x != 0) {
            int d = x % 10;

            if((revNum > Integer.MAX_VALUE/10) || (revNum < Integer.MIN_VALUE/10) || (revNum == Integer.MAX_VALUE/10 && d > 7) || (revNum == Integer.MIN_VALUE/10 && d < -8)) {
                return 0;
            }

            revNum = (revNum * 10) + d;
            x = x/10;
        }

        return revNum;
    }
}
class Solution {
    public int integerReplacement(int n) {
        return minops((long) n);
    }

    private int minops(long n) {
        int count = 0;

        while(n > 1) {
            if((n & 1) == 0) {
                n = n/2;
            }
            else {
                if((n == 3) || ((n & 2) == 0)) {
                    n--;
                }
                else {
                    n++;
                }
            }
            count++;
        }

        return count;
    }
}
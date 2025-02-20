class Solution {
    public int binaryGap(int n) {
        int c = 0;
        // int num1 = 0;
        // int num2 = 0;
        int num1 = -1;
        int num2 = -1;
        // int t = n;
        // int d = 0;
        // int diff = 0;
        int maxdiff = 0;

        // while(t > 0) {
        //     d++;
        //     t = t >> 1;
        // }
        while(n > 0) {
            if((n & 1) == 1) {
                if(num1 == -1) {
                    num1 = c;
                }
                else {
                    num2 = c;
                    maxdiff = Math.max(maxdiff, (num2 - num1));
                    num1 = num2;
                }
            }
            n = n >> 1;
            c++;
            // c++;
            // if((n & 1) == 1) {
            //     num1 = d - c;
            // }
            // n = n >> 1;
            // c++;
            // if((n & 1) == 1) {
            //     num2 = d - c;
            // }
            // if(num1 != 0 && num2 != 0) {
            //     diff = Math.abs(num2 - num1);
            // }
            // maxdiff = Math.max(diff, maxdiff);
        }
        return maxdiff;
    }
}
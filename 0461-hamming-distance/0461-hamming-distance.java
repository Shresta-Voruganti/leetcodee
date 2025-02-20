class Solution {
    public int hammingDistance(int x, int y) {
        int val = x ^ y;
        // int sum = bitcount(val);
        int sum = Integer.bitCount(val);

        return sum;
    }

    // private int bitcount(int ele) {
    //     int count = 0;
    //     while(ele > 0) {
    //         if((ele & 1) == 1) {
    //             count++;
    //         }
    //         ele = ele >> 1;
    //     }

    //     return count;
    // }

}
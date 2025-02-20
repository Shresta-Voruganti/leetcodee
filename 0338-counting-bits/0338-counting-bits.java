class Solution {
    public int[] countBits(int n) {
        // int[] arr = new int[n + 1];
        // for(int i = 0; i < n + 1; i++) {
        //     arr[i] = i;
        // }
        // int[] res = new int[n + 1];
        // for(int i = 0; i < n + 1; i++) {
        //     res[i] = bitcount(arr[i]);
        // }

        // return res;

        int[] res = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Use the relationship to calculate the number of 1s
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
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
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int count = 0;
        int prefixsum = 0;
        int oddcount = 0;
        int evencount = 1;

        for(int num : arr) {
            prefixsum += num;
            if((prefixsum & 1) == 0) {
                count += oddcount;
                evencount++;
            }
            else {
                count += evencount;
                oddcount++;
            }
            count %= MOD;
        }

        
        return count;
    }
}
class Solution {
    public int smallestNumber(int n) {
        int i = 32 - Integer.numberOfLeadingZeros(n);
        return (1 << i) - 1;
    }
}
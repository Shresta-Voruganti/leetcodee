class Solution {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        long left = 1;
        long right = x/2;
        while(left <= right) {
            long mid = left + (right - left)/2;
            long square = mid * mid;
            if(x == square) {
                return (int) mid;
            }
            else if(x > square) { // target > arr[i] types
                left = mid + 1;
            }
            else { // x < square // target < arr[i] types
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
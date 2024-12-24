class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long left = 1;
        long right = num/2;
        while(left <= right) {
            long mid = left + (right-left)/2;
            long square = mid * mid;
            if(num == square) {
                return true;
            }
            else if(num > square) { // target > arr[i] types
                left = mid + 1;
            }
            else { // square > num // target < arr[i] types
                right = mid - 1;
            }
        }
        return false;
    }
}
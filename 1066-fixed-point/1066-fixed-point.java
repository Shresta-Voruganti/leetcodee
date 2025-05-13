class Solution {
    public int fixedPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == mid) {
                result = mid;  // potential answer found
                high = mid - 1; // search for a smaller index in the left half
            } else if (arr[mid] < mid) {
                low = mid + 1; // search in the right half
            } else {
                high = mid - 1; // search in the left half
            }
        }
        
        return result; // return the smallest fixed point found, or -1 if none exists
    }
}
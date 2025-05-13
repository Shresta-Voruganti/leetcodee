class Solution {
    public int smallestCommonElement(int[][] mat) {
        if (mat.length == 1) return mat[0][0];
        
        for (int a : mat[0]) {  // Check each element in the first row
            int count = 0;
            for (int i = 1; i < mat.length; i++) {  // Check each subsequent row
                if (binarySearch(mat[i], 0, mat[i].length - 1, a)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == mat.length - 1) return a;  // Found common element
        }
        return -1;  // No common element found
    }

    private boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
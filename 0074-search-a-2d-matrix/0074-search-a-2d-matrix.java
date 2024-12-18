class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            int midvalue = matrix[mid/n][mid%n];
            if(target == midvalue) {
                return true;
            }
            else if(target < midvalue) {
                right = mid-1;
            }
            else { //target > midvalue
                left = mid+1;
            }
        }
        return false;
    }
}
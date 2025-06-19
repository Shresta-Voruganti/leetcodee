class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] matrix = new int[n][n];

        while(top <= bottom && left <= right) {
            addCols(matrix, left, right + 1, top);
            top++;
            addRows(matrix, top, bottom + 1, right);
            right--;
        
            if(top <= bottom) {
                addColsReverse(matrix, right, left - 1, bottom);
                bottom--;
            }

            if(left <= right) {
                addRowsReverse(matrix, bottom, top - 1, left);
                left++;
            }
        }

        return matrix;
    }
    private int num = 1;
    private void addCols(int[][] matrix, int start, int end, int row) {
        for(int i = start; i < end; i++) {
            matrix[row][i] = num;
            num++;
        }
    }

    private void addColsReverse(int[][] matrix, int start, int end, int row) {
        for(int i = start; i > end; i--) {
            matrix[row][i] = num;
            num++;
        }
    }

    private void addRows(int[][] matrix, int start, int end, int col) {
        for(int i = start; i < end; i++) {
            matrix[i][col] = num;
            num++;
        }
    }

    private void addRowsReverse(int[][] matrix, int start, int end, int col) {
        for(int i = start; i > end; i--) {
            matrix[i][col] = num;
            num++;
        }
    }
}
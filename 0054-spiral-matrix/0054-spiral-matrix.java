class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
       
        while(top <= bottom && left <= right) {
            addCols(matrix, left, right + 1, res, top);
            top++;
            addRows(matrix, top, bottom + 1, res, right);
            right--;
            
            if(top <= bottom) {
                addColsReverse(matrix, right, left - 1, res, bottom);
                bottom--;
            }
            

            if(left <= right) {
                addRowsReverse(matrix, bottom, top - 1, res, left);
                left++;
            }
           
        }
        return res;
    }

    private void addCols(int[][] matrix, int start, int end, List<Integer> res, int row) {
        for(int i = start; i < end; i++) {
            res.add(matrix[row][i]);
        }
    }

    private void addColsReverse(int[][] matrix, int start, int end, List<Integer> res, int row) {
        for(int i = start; i > end; i--) {
            res.add(matrix[row][i]);
        }
    }

    private void addRows(int[][] matrix, int start, int end, List<Integer> res, int col) {
        for(int i = start; i < end; i++) {
            res.add(matrix[i][col]);
        }
    }

    private void addRowsReverse(int[][] matrix, int start, int end, List<Integer> res, int col) {
        for(int i = start; i > end; i--) {
            res.add(matrix[i][col]);
        }
    }
}
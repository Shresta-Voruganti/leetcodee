/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode node;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        node = head;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int[][] matrix = new int[m][n];

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

    private void addCols(int[][] matrix, int start, int end, int row) {
        for(int i = start; i < end; i++) {
            matrix[row][i] = (node != null) ? node.val : -1;
            node = (node != null) ? node.next : null;
        }
    }

    private void addColsReverse(int[][] matrix, int start, int end, int row) {
        for(int i = start; i > end; i--) {
            matrix[row][i] = (node != null) ? node.val : -1;
            node = (node != null) ? node.next : null;
        }
    }

    private void addRows(int[][] matrix, int start, int end, int col) {
        for(int i = start; i < end; i++) {
            matrix[i][col] = (node != null) ? node.val : -1;
            node = (node != null) ? node.next : null;
        }
    }

    private void addRowsReverse(int[][] matrix, int start, int end, int col) {
        for(int i = start; i > end; i--) {
            matrix[i][col] = (node != null) ? node.val : -1;
            node = (node != null) ? node.next : null;
        }
    }
}
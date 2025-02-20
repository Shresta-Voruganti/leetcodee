class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] x = new int[n]; // Array to store the column positions of queens
        solve(0, n, x, results);
        return results;
    }
    private static void solve(int k, int n, int[] x, List<List<String>> results) {
        if (k == n) {
            // All queens are placed, add the solution to the results
            results.add(createBoard(x, n));
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(k, i, x)) {
                    x[k] = i; // Place the queen in column i of row k
                    solve(k + 1, n, x, results); // Recurse to the next row
                }
            }
        }
    }
    private static boolean isValid(int k, int i, int[] x) {
        for (int j = 0; j < k; j++) {
            // Check column and diagonal conflicts
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }
    private static List<String> createBoard(int[] x, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = (x[i] == j) ? 'Q' : '.';
            }
            board.add(new String(row));
        }
        return board;
    }
}
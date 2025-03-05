class Solution {
    public long coloredCells(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }

        return coloredCells(n - 1) + (4L * (n - 1));
    }
}
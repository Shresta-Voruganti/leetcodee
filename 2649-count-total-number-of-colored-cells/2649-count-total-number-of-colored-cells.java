class Solution {
    public long coloredCells(int n) {
        return ff(n);
    }

    private long ff(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        return ff(n - 1) + (4L * (n - 1));
        
    }
}
class Solution {
    public int smallestNumber(int n) {
        if(n == 1) return 1;
        int res = n;
        for(int i = 1; ; i++) {
            int x = (int) Math.pow(2, i);
            if(x - 1 >= n) {
                res = x - 1;
                break;
            }
        }
        return res;
    }
}
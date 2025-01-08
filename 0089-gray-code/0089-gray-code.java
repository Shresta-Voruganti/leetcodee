class Solution {
    int x = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        backtrack(n, res);
        return res;
    }

    private void backtrack(int n, List<Integer> res) {
        if(n == 0) {
            res.add(x);
            return;
        }
        else {
            backtrack(n - 1, res);
            x = x ^ (1 << (n-1));
            backtrack(n - 1, res);
        }
    }
}
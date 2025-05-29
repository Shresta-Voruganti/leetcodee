class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int start, List<Integer> temp, List<List<Integer>> res) {
        for(int i = start; i <= n/i; i++) {
            if(n % i == 0) {
                temp.add(i);
                temp.add(n/i);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1); // remove n/i
                backtrack(n/i, i, temp, res);
                temp.remove(temp.size() - 1); // remove i
            }
        }
    }
}
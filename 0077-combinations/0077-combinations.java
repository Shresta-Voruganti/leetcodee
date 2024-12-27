class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, res, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, List<List<Integer>> res, int k, List<Integer> tempList) {
        if(tempList.size()==k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int j=i; j<=n; j++) {
            tempList.add(j);
            backtrack(j+1, n, res, k, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int i, int target, List<List<Integer>> res, List<Integer> tempList) {
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int j=i; j<candidates.length; j++) {
            tempList.add(candidates[j]);
            backtrack(candidates, j, target-candidates[j], res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
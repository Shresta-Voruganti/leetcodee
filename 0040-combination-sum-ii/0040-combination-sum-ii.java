class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int i, int target, List<List<Integer>> res, List<Integer> tempList) {
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        // if(target == 0) {
        //     if(!res.contains(tempList)) {
        //         res.add(new ArrayList<>(tempList));
        //     }
        //     return;
        // }
        // if(target < 0) {
        //     return;
        // }

        for(int j=i; j<candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            if(candidates[j] > target) {
                break;
            }

            tempList.add(candidates[j]);
            backtrack(candidates, j+1, target-candidates[j], res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
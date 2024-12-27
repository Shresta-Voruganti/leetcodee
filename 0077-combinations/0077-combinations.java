class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // int[] nums = new int[n];
        // for(int i=0; i<n; i++) {
        //     nums[i] = i+1;
        // }
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
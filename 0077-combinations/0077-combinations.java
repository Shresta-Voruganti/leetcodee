class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<List<Integer>> res, int k, List<Integer> tempList) {
        if(tempList.size()==k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int j=i; j<nums.length; j++) {
            tempList.add(nums[j]);
            backtrack(nums, j+1, res, k, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int i, List<List<Integer>> res) {
        if(i==nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for(int num : nums) {
                tempList.add(num);
            }
            res.add(tempList);
            return;
        }

        for(int j=i; j<nums.length; j++) {
            swap(nums, i, j);
            backtrack(nums, i+1, res);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int index = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while(index < n) {
            nums[index++] = 0;
        }
        return nums;
    }
}
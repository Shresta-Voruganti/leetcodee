class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(n < k || sum % k != 0) {
            return false;
        }

        int side = sum/k;
        Arrays.sort(nums);
        reverse(nums);

        int[] sides = new int[k];
        return backtrack(nums, 0, sides, side);
    }

    private boolean backtrack(int[] nums, int index, int[] sides, int targetside) {
        if(index == nums.length) {
            for(int i = 0; i < sides.length; i++) {
                if(sides[i] != targetside) {
                    return false;
                }
            }
            return true;
        }

        for(int i = 0; i < sides.length; i++) {
            if(sides[i] + nums[index] <= targetside) {
                sides[i] += nums[index];
                if(backtrack(nums, index + 1, sides, targetside)) {
                    return true;
                }
                sides[i] -= nums[index];
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
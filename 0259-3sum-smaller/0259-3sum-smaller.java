class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            count += twoSum(nums, i, target);
        }
        return count;
    }

    private int twoSum(int[] nums, int i, int target) {
        int low = i + 1;
        int high = nums.length - 1;
        int count = 0;
        while(low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if(sum >= target) {
                high--;
            }
            else {
                // all values from low to high - 1 with nums[i] are valid
                count += high - low;
                low++;
            }
        }
        return count;
    }
}
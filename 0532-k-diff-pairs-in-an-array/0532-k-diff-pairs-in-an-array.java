class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int i = 0;
        int j = 1;

        while(j < n) {
            if(i == j || nums[j] - nums[i] < k) {
                j++;
            }
            else if(nums[j] - nums[i] > k) {
                i++;
            }
            else {
                int a = nums[i];
                int b = nums[j];
                count++;

                while(i < n && nums[i] == a) {
                    i++;
                }
                while(j < n && nums[j] == b) {
                    j++;
                }
            }
        }
        return count;
    }
}
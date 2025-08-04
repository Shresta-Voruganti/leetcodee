class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int curend = 0;
        int maxreach = 0;

        // loop through all positions except the last one - as we don't need the value at last index
        for(int i = 0; i < n - 1; i++) {
            maxreach = Math.max(maxreach, i + nums[i]);

            if(i == curend) {
                steps++;
                curend = maxreach;
            }
        }

        return steps;
    }
}
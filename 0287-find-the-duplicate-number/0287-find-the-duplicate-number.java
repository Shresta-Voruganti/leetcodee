class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        for(int i = 0; i <= n; i++) {
            if(vis[nums[i]]) return nums[i];
            vis[nums[i]] = true;
        }
        return -1;
    }
}
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stackk = new Stack<>();
        for(int i=0; i<n; i++) {
            if(stackk.isEmpty() || nums[stackk.peek()] > nums[i]) {
                stackk.push(i);
            }
        }
        int maxramp = 0;
        for(int j=n-1; j>=0; j--) {
            while(!stackk.isEmpty() && nums[stackk.peek()] <= nums[j]) {
                int i = stackk.pop();
                maxramp = Math.max(maxramp, j-i);
            }
        }
        return maxramp;
    }
}
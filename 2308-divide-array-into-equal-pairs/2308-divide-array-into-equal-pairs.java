class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            freq[nums[i]]++;
        }

        for(int i = 0; i < 501; i++) {
            if((freq[i] & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}
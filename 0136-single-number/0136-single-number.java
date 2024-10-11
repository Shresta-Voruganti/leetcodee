class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for(int num : nums)
        {
            r = r^num;
        }
        return r;
    }
}
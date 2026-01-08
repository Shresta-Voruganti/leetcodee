class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortnums = nums.clone();
        Arrays.sort(sortnums);
        int[] vals = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int idx = Arrays.binarySearch(sortnums, nums[i]);
            while(idx > 0 && sortnums[idx - 1] == nums[i]) {
                idx--;
            }
            vals[i] = idx;
        }
        return vals;
    }
}
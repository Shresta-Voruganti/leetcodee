class Solution {
    public boolean check(int[] nums) {
        boolean res = false;
        int x = 0;
        int[] numsNew = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsNew);
        while(x < nums.length) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(numsNew[i] == nums[(i+x)%(nums.length)]) {
                    count++;
                }
            }
            if(count!=nums.length) {
                x++;
            }
            else {
                res = true;
                break;
            }
        }
        return res;
    }
}
class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean res = true;
        for(int i = 1; i < nums.length; i++) {
            if(findParity(nums[i]) == findParity(nums[i - 1])) {
                res = false;
                break;
            }
        }
        return res;
    }

    private int findParity(int num) {
        if(num % 2 == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
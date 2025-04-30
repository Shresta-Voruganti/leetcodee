class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(isEven(countDig(nums[i]))) {
                c++;
            }
        }
        return c;
    }

    private boolean isEven(int n) {
        if(n % 2 == 0) {
            return true;
        }
        return false;
    }

    private int countDig(int n) {
        int c = 0;
        while(n > 0) {
            c++;
            n = n/10;
        }
        return c;
    }
}
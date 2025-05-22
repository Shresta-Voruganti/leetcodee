class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int bal = -1;

        for(int i = 0; i < n; i++) {
            int sumg = 0;
            int sumd = 0;
            if(i == 0) {
                sumg  += sumCalc(nums, 0, 1);
                sumd = 0;
            }
            else if(i == n - 1) {
                sumg = 0;
                sumd += sumCalc(nums, n - 1, -1);
            }
            else {
                sumg += sumCalc(nums, i, 1);
                sumd += sumCalc(nums, i, -1);
            }
            if(sumg == sumd) {
                bal = i;
                break;
            }
        }
        return bal;
    }

    private int sumCalc(int[] arr, int index, int inc) {
        int n = arr.length;
        int sum = 0;
        if(inc > 0) {
            for(int i = index + 1; i < n; i++) {
                sum += arr[i];
            }
        }
        else {
            for(int i = index - 1; i >= 0; i--) {
                sum += arr[i];
            }
        }
        return sum;
    }
}

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int pivotcount = 0;

        for(int num : nums) {
            if(num < pivot) {
                res[left++] = num;
            }
            else if(num == pivot) {
                pivotcount++;
            }
        }

        while(pivotcount-- > 0) {
            res[left++]= pivot;
        }

        for(int num : nums) {
            if(num > pivot) {
                res[left++] = num;
            }
        }

        return res;
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
       k = k % nums.length;
        // if(nums.length == 1) {
        //     return nums;
        // }

        // if(k == 0) {
        //     return nums;
        // }
        reverseOrder(nums, 0, nums.length);
        reverseOrder(nums, 0, k);
        reverseOrder(nums, k, nums.length);

        // return arr; 
    }

    private int[] reverseOrder(int[] arr, int start, int end) {
        int left = start, right = end - 1;
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }
}
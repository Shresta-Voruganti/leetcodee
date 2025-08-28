class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if(ind == -1) {
            reverse(nums);
            return;
        }

        for(int i = n - 1; i >= ind; i--) {
            if(nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        reversei(nums, ind + 1, n - 1);
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int ind) {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
        return;
    }

    private void reversei(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
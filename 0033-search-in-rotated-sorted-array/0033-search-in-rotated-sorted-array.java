class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(target == nums[mid]) {
                return mid;
            }
            // left half sorted
            if(nums[left] <= nums[mid]) {
                // nums][left] <= target < nums[mid]
                if(nums[left] <= target && target < nums[mid]) { 
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            // right half sorted
            else {
                // nums[mid] < target <= nums[right]
                if(nums[right] >= target && target > nums[mid]) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        } 
        return -1;
    }
}
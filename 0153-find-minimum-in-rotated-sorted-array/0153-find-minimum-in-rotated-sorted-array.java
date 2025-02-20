class Solution {
    public int findMin(int[] nums) {
        // int min;
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }

            
            // if(nums[mid] < nums[high] && nums[mid] < nums[low]) {
            //     min = nums[mid];
            //     return min;
            // } 
            // else if(nums[mid] > nums[high]) {
            //     low = mid + 1;
            // }
            // else if(nums[mid] > nums[low]) {
            //     high = mid - 1;
            // }
        }

        // return -1;
        return nums[low];
    }
}
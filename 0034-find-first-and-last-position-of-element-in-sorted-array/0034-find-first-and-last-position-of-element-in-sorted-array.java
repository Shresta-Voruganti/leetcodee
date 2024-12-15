class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};

        // for finding first occurence
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            if(target==nums[mid]) {
                res[0] = mid;
                high = mid-1; // Move left to find the first occurrence
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else { //target < nums[mid]
                high = mid-1;
            }
        }
        if(res[0]==-1) {
            return res;
        }
        
        // for finding last occurence
        low = res[0];
        high = nums.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            if(target==nums[mid]) {
                res[1] = mid;
                low = mid+1; // Move right to find the last occurrence
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else { //target < nums[mid]
                high = mid-1;
            }
        } 
        return res;
    }   
}
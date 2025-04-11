class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;

        while(!isSorted(nums)) {
            int minsum = Integer.MAX_VALUE;
            int minIndex = 0;
            
            for(int i = 0; i < nums.length-1; i++) {
                int sum = nums[i] + nums[i + 1];
                if(sum < minsum) {
                    minIndex = i;
                    minsum = sum;
                }
            }
            nums = mergeIndex(nums, minIndex);
            count++;
        }
        
        return count;
    }
    
    private boolean isSorted(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] mergeIndex(int[] nums, int index) {
        int[] newVals = new int[nums.length - 1];
        int newval = nums[index] + nums[index + 1];
        
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(i == index) {
                newVals[j] = newval;
                j++;
                i++;
            }
            else {
                newVals[j] = nums[i];
                j++;   
            }
        }
        
        return newVals;
    }
}
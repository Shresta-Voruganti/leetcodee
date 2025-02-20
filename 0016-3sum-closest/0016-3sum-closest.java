class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // int sum  = 0;
        Arrays.sort(nums);
        int mindiff = Integer.MAX_VALUE;
        int sum1 = 0;
        for(int i = 0; i < n - 2; i++) {
            int newtarget = target - nums[i];
            int val = closestpair(nums, newtarget, i + 1, n - 1);
            int sum = nums[i] + val;
            int diff = Math.abs(sum - target);
            if(diff < mindiff) {
                mindiff = diff;
                // sum1 = nums[i] + val;
                sum1 = sum;
            }
        }
        return sum1;
    }

    private int closestpair(int[] arr, int target, int left, int right) {
        // int sum1 = 0;
        int sum1 = arr[left] + arr[right];
        // int left = 0;
        // int right = arr.length - 1;
        // int sum = 0;
        // int mindiff = Integer.MAX_VALUE;
        int mindiff = Math.abs(sum1 - target);
        // while(left < arr.length && right >= 0) 
        while(left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);

            if(diff < mindiff) {
                mindiff = diff;
                // sum1 = arr[left] + arr[right];
                sum1 = sum;
            }

            if(sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return sum1;
    }
}
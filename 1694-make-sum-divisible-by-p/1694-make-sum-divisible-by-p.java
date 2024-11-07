import java.util.HashMap;
class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int num : nums) {
            sum = (sum + num)%p;
        }
        //we calculated remainder in the loop itself, so that, the variable sum can hold the value easily without integer overflow.
        /*
        instead of writing: 
        for(int num : nums) {
            sum = sum+num;
        }
        int remainder = sum%p;
        because, if we have larger values in nums, then adding each num to sum will cause overflow, so we instead sum up remainders, making it easier for the sum variable to store., so as we are calculating sum in that way, it's the total remainder that we are getting in the end, hence, we didnt write another variable as remainder explicitly
        */
        if(sum==0) {
            return 0;
        }
        HashMap<Integer,Integer> modmap = new HashMap<>();
        modmap.put(0, -1);
        int prefixsum = 0;
        int minlen = nums.length;
        for(int i=0; i<nums.length; i++) {
            prefixsum = (prefixsum + nums[i]) % p;
            int targetmod = (prefixsum - sum + p) % p;
            if(modmap.containsKey(targetmod)) {
                minlen = Math.min(minlen, i-modmap.get(targetmod));
            }
            modmap.put(prefixsum, i);
        }
        return minlen == nums.length ? -1 : minlen;
    }
}
class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length; //length of input array
        long count = 0; //stores final result - number of good subarrays
        int same = 0; //stores the number of good pairs in the current window
        int right = -1; //right boundary of our current window (initialised before start)
        Map<Integer, Integer> hmap = new HashMap<>(); //keeps track of the freq of all elements in current window
        //we iterate over all possible 'left' starting positions of the subarray
        for(int left = 0; left < n; left++) {
            while(same < k && right + 1 < n) {
                ++right; //we move 'right' forward to expand the window until the current window contains atleast 'k' good pairs
                same += hmap.getOrDefault(nums[right], 0); 
                //everytime we add nums[right]: we add to 'same', the count of previous occurences of that number, since those will now form new good pairs, then, we increment its freq in map
                hmap.put(nums[right], hmap.getOrDefault(nums[right], 0) + 1);
            }
            //once the current window [left,right] has atleast 'k' good pairs, then -> any subarray ending at 'right', 'right+1',...,'n-1' (inclusive) will also have >= 'k' good pairs, so we add 'n - right' to the result (count - here)
            if(same >= k) {
                count += n - right;
            }
            //as we slide the window forward (increment 'left'), we decrease the freq of nums[left], then we remove from 'same', the number of pairs that nums[left] was contributing after decrementing
            hmap.put(nums[left], hmap.get(nums[left]) - 1);
            same -= hmap.get(nums[left]);
            //why after? -> because a val appearing 'f' times contributes 'f*(f-1)/2' pairs - and when one occurence is removed, the number of pairs contributed by it reduces by 'f-1'
        }
        //return the total number of subarrays with atleast 'k' good pairs
        return count;
    }
}
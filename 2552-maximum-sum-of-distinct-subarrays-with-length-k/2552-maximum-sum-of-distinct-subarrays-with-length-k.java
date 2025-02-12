class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(k > nums.length) {
           return 0;
        }
        long max = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        long sum  = 0;
        for(int i = 0; i < k; i++) 
        {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        if(hmap.size() == k) 
        {
            // sum = sumh(hmap);
            max = sum;
        }
        // max = Math.max(sum, max);
        for(int i = k; i < nums.length; i++) 
        {
            int outEle = nums[i - k];
            if(hmap.get(outEle) == 1) 
            {
                hmap.remove(outEle);
            }
            else 
            {
                hmap.put(outEle, hmap.get(outEle) - 1);
            }
            sum -= outEle;
            int inEle = nums[i];
            hmap.put(inEle, hmap.getOrDefault(inEle, 0) + 1);
            sum += inEle;
            if(hmap.size() == k) 
            {
                // sum = sumh(hmap);
                max = Math.max(sum, max);
            }
            // max = Math.max(sum, max);
        }
        return max;
    }

    // private int sumh(Map<Integer, Integer> hmap) {
    //     int sum = 0;
    //     for(int val : hmap.keySet()) {
    //         sum += val;
    //     }
    //     return sum;
    // }
}
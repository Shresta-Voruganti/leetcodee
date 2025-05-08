class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int k = 3;
        // Map<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        int n = nums.length;

        while(k <= n) {
            // for(int i = 0; i < k; i++) {
            //     hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            // }
            if(isap(nums, 0, k)) {
                count++;
            }

            for(int i = k; i < n; i++) {
                // int out = nums[i - k];
                // int in = nums[i];
                // if(hmap.get(out) > 1) {
                //     hmap.put(out, hmap.get(out) - 1);
                // }
                // else {
                //     hmap.remove(out);
                // }
                // hmap.put(in, hmap.getOrDefault(in, 0) + 1);
                if(isap(nums, i - k + 1, k)) {
                    count++;
                }
            }
            k++;
        }
        return count;
    }

    private boolean isap(int[] nums, int start, int inc) {
        int end = start + inc;
        int diff = nums[start + 1] - nums[start];
        for(int i = start; i < end - 1; i++) {
            if(nums[i + 1] - nums[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
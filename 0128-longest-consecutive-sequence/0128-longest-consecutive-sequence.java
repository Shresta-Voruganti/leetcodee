class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hset = new HashSet<>();
        for(int num : nums) {
            if(!hset.contains(num)) {
                hset.add(num);
            }
        }

        int maxlen = 0;

        for(int num : hset) {
            if(!hset.contains(num - 1)) {
                int curr = num;
                int currlen = 1;

                while(hset.contains(curr + 1)) {
                    curr++;
                    currlen++;
                }

                maxlen = Math.max(maxlen, currlen);
            }
        }

        return maxlen;
    }
}
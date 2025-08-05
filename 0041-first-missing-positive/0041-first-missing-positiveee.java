class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hset = new HashSet<>();
        for(int num : nums) {
            hset.add(num);
        }

        int n = 1;
        while(hset.contains(n)) {
            n++;
        }
        return n;
    }
}

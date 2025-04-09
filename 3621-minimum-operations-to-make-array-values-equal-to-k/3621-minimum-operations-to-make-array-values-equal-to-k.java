class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] hasele = new boolean[101];
        int op = 0;

        for(int num : nums) {
            hasele[num] = true;
        }

        for(int i = 0; i < hasele.length; i++) {
            if(!hasele[i]) {
                continue;
            }

            if(hasele[i] && i < k) {
                op = -1;
                return op;
            }
            else if(hasele[i] && i > k) {
                op++;
            }
        }
        return op;
    }
}
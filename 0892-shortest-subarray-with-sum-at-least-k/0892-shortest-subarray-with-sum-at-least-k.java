class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixsum = new long[n + 1];
        int minlength = n + 1;

        for(int i = 0; i < n; i++) {
            prefixsum[i + 1] = prefixsum[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();

        for(int right = 0; right < prefixsum.length; right++) {
            while(!deque.isEmpty() && prefixsum[right] <= prefixsum[deque.getLast()]) {
                deque.removeLast();
            }

            while(!deque.isEmpty() && prefixsum[right] >= prefixsum[deque.getFirst()] + k) {
                int left = deque.removeFirst();
                minlength = Math.min(minlength, right - left);
            }

            deque.addLast(right);
        }

        return minlength <= n ? minlength : -1;
    }
}
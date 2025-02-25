class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[][] res = new int[n][2];
        for(int i = 0; i < n; i++) {
            res[i][0] = sumofdig(nums[i]);
            res[i][1] = nums[i];
        }
        Map<Integer, PriorityQueue<Integer>> hmap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int digsum = res[i][0];
            int num = res[i][1];

            hmap.putIfAbsent(digsum, new PriorityQueue<>(Collections.reverseOrder()));
            hmap.get(digsum).add(num);
        }

        int maxsum = -1;
        for(PriorityQueue<Integer> pq : hmap.values()) {
            if(pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                maxsum = Math.max(maxsum, first + second);
            }
        }
        return maxsum;

    }

    private int sumofdig(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}
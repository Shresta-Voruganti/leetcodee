class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        for(int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res.add(pq.peek()[0]);

        for(int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            while(pq.peek()[1] <= i - k) {
                pq.poll();
            }

            res.add(pq.peek()[0]);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
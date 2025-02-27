class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        for(int num : nums) {
            minheap.add((long) num);
        }
        int count = 0;

        // while(minheap.peek() < k) 
        while(minheap.size() > 1 && minheap.peek() < k) {
            long fmin = minheap.poll();
            long smin = minheap.poll();
            // int insertx = Math.min(fmin, smin) * 2 + Math.max(fmin, smin);
            long insertx = fmin * 2 + smin;
            minheap.add(insertx);
            count++;
        }

        // while(!minheap.isEmpty() && minheap.peek() < k) {
        //     if(minheap.size() < 2) {
        //         return -1;
        //     }
        //     int fmin = minheap.poll();
        //     int smin = minheap.poll();
        //     // int insertx = Math.min(fmin, smin) * 2 + Math.max(fmin, smin);
        //     int insertx = fmin * 2 + smin;
        //     minheap.add(insertx);
        //     count++;
        // }

        // if(minheap.isEmpty() || minheap.peek() < k) {
        //     return count;
        // }
        
        
        // return (minheap.peek() >= k) ? count : count + 1;
        // return (minheap.peek() >= k) ? count : -1;
        return count;
    }
}
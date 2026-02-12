// Top-down Dynamic Programming
class Solution {
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int maxnum = 0;

        for(int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxnum = Math.max(maxnum, num);
        }

        return maxpoints(maxnum);
    }

    private int maxpoints(int num) {
        if(num == 0) {
            return 0;
        }

        if(num == 1) {
            return points.getOrDefault(1, 0);
        }

        if(cache.containsKey(num)) {
            return cache.get(num);
        }

        int gain = points.getOrDefault(num, 0);
        int ans = Math.max(maxpoints(num - 1), maxpoints(num - 2) + gain);
        cache.put(num, ans);

        return ans;
    }
}

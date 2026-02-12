// Bottom-Up Dynamic Programming
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();

        int maxnum = 0;

        for(int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxnum = Math.max(maxnum, num);
        }

        int[] maxpoints = new int[maxnum + 1];
        maxpoints[1] = points.getOrDefault(1, 0);

        for(int i = 2; i < maxnum + 1; i++) {
            int gain = points.getOrDefault(i, 0);
            maxpoints[i] = Math.max(maxpoints[i - 1], maxpoints[i - 2] + gain);
        }

        return maxpoints[maxnum];
    }
}

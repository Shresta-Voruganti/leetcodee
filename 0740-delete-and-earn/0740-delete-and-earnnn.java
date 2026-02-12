// Space-optimised Dynamic Programming
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();

        int maxnum = 0;

        for(int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxnum = Math.max(maxnum, num);
        }

        int twoback = 0;
        int oneback = points.getOrDefault(1, 0);

        for(int i = 2; i < maxnum + 1; i++) {
            int gain = points.getOrDefault(i, 0);
            int current = Math.max(oneback, twoback + gain);

            twoback = oneback;
            oneback = current;
        }

        return oneback;
    }
}

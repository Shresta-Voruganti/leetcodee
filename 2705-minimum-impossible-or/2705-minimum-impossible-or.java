class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s1 = new HashSet<>();
        for(int num : nums) {
            s1.add(num);
        }

        int power = 1;
        while(s1.contains(power)) {
            // power = power * 2;
            // power *= 2;
            // power <<= 1;
            power = power << 1;
        }

        return power;
    }
}
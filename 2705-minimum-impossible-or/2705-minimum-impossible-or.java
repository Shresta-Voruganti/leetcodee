class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s1 = new HashSet<>();
        for(int num : nums) {
            s1.add(num);
        }

        int power = 1;
        while(s1.contains(power)) {
            power *= 2;
        }

        return power;
    }
}
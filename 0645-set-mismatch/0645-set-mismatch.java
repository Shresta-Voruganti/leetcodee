class Solution {
    public int[] findErrorNums(int[] nums) {
        int sz = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 1; i <= sz; i++) {
            hmap.put(i, 0);
        }
        for(int d : nums) {
            hmap.put(d, hmap.getOrDefault(d, 0) + 1);
        }
        int duplicated = 0;
        int missing = 0;
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            int num = e.getKey();
            int val = e.getValue();
            if(val == 0) {
                missing = num;
            }
            else if(val > 1) {
                duplicated = num;
            }

            if(duplicated != 0 && missing != 0) {
                break;
            }
        }
        // hmap.put(duplicated, hmap.get(duplicated) - 1);
        // hmap.put(missing, hmap.get(missing) + 1);
        int[] newnums = new int[2];
        newnums[0] = duplicated;
        newnums[1] = missing;
        return newnums;
    }
}
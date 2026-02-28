class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
        for(int num : nums) {
            tmap.put(num, tmap.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        int[] res = new int[2];
        List<int[]> al = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < n - 1; i++) {
            int fe = nums[i];
            int j = i + 1;
            while(j < n) {
                while(j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
                if(j < n && !tmap.get(nums[j]).equals(tmap.get(nums[i]))) {
                    al.add(new int[]{fe, nums[j]});
                    break;
                }
                j++;
            }
        }
        
        Collections.sort(al, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        return al.size() > 0 ? al.get(0) : new int[]{-1, -1};
    }
}
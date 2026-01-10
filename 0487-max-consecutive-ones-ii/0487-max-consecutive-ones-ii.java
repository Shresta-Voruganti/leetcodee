class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> pos = new ArrayList<Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) pos.add(i);
        }
        int maxcount = findconsecOnes(nums);
        if(pos.isEmpty()) return maxcount;
        for(Integer d : pos) {
            nums[d] = 1;
            int con = findconsecOnes(nums);
            maxcount = Math.max(maxcount, con);
            nums[d] = 0;
        }
        return maxcount;
    }

    private int findconsecOnes(int[] nums) {
        int count = 0;
        int maxcount = 0;
        int n = nums.length;
        int consec = 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                count++;
            }
            else {
                count = 0;
                consec = 1;
            }

            if(i == 0) {
                if(nums[i] == 1) {
                    maxcount = Math.max(maxcount, consec);
                }
            }
            if(i > 0) {
                if(nums[i] == 1 && nums[i - 1] == 1) {
                    consec++;
                    maxcount = Math.max(maxcount, consec);
                }
                else if(nums[i] == 1) {
                    maxcount = Math.max(maxcount, consec);
                }
            }
            
        }
        return maxcount;
    }
}
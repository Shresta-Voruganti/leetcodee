class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        // int[] temp1 = new int[n - 1];
        List<Integer> temp1 = new ArrayList<>();
        // int[] temp2 = new int[n - 1];
        List<Integer> temp2 = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(i != 0) {
                temp1.add(nums[i]);
            }
            if(i != n - 1) {
                temp2.add(nums[i]);
            }
        }

        int curi = Math.max(rob1(temp1.stream().mapToInt(i -> i).toArray()), rob1(temp2.stream().mapToInt(i -> i).toArray()));

        return curi;
    }

    private int rob1(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            int take = nums[i];
            if(i > 1) {
                take += prev2;
            }
            int not_take = 0 + prev;
            int curi = Math.max(take, not_take);
            prev2 = prev;
            prev = curi;
        }

        return prev;
    }
}
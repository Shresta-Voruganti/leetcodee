class Solution {
    public int minOperations(int[] nums) {
        int k = 3;
        int count = 0;
        boolean canflip = false;
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }

        if (res.get(0) == 0) {
            canflip = true;
        }
        if (canflip) {
            fliplist(res);
            updateArray(nums, 0, res); 
            count++;
        }
        canflip = false;

        for (int i = k; i < n; i++) {
            res.remove(0); 
            res.add(nums[i]); 

            if (res.get(0) == 0) {
                canflip = true;
            }
            if (canflip) {
                fliplist(res);
                updateArray(nums, i - k + 1, res);
                count++;
            }
            canflip = false;
        }

        if (checkones(nums)) {
            return count;
        }

        return -1;
    }

    private void fliplist(List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            res.set(i, 1 - res.get(i));
        }
    }

    private void updateArray(int[] nums, int start, List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            nums[start + i] = res.get(i);
        }
    }

    private boolean checkones(int[] nums) {
        for (int num : nums) {
            if (num == 0) {
                return false;
            }
        }
        return true;
    }
}

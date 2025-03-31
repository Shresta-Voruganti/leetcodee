class NumArray {
    int n;
    int[] BIT;
    int[] nums;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.BIT = new int[n + 1];
        for(int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while(i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }

    public int getSum(int i) {
        i++;
        int sum = 0;
        while(i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
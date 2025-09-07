class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] increase = nums.clone();
        Arrays.sort(increase);
        int[] decrease = new int[n];
        for(int i = 0; i < n; i++) {
            decrease[i] = increase[n - i - 1];
        }
        int ind = 0;
        int i = 0;
        // int assigned = 0;
        int j = 0;

        while(ind < n - 1) {
            nums[ind++] = increase[i++];
            // assigned++;
            nums[ind++] = decrease[j++];
        }

        if(n % 2 == 1) {
            nums[ind] = increase[i++];
        }
    }
}
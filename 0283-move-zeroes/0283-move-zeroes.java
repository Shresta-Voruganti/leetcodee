class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonzeroIndex = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=0)
            {
                nums[nonzeroIndex++] = nums[i];
            }
        }

        while(nonzeroIndex < n)
        {
            nums[nonzeroIndex++] = 0;
        }

        System.out.print(Arrays.toString(nums));
    }
}

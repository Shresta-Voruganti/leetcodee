class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int [] resarr = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int sum = 0;
            for(int j=i+1;j<nums.length;j++)
            {
                sum = nums[i]+nums[j];
                if(target==sum)
                {
                    resarr[0] = i;
                    resarr[1] = j;
                    break;
                }
            }
        }
        return resarr;
    }
}
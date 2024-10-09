import java.util.Hashtable;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer,Integer> checkdup = new Hashtable<>();
        // for(int i=0; i<nums.length; i++)
        // {
        //     int count = 1;
        //     if(checkdup.containsKey(nums[i]))
        //     {
        //         count++;
        //         checkdup.put(nums[i],count);
        //     }
        //     checkdup.put(nums[i],count);
        // }

        for(int ch : nums)
        {
            checkdup.put(ch, checkdup.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Integer,Integer> e : checkdup.entrySet())
        {
            if(e.getValue()>1)
            {
                return true;
            }
        }
        return false;
    }
}
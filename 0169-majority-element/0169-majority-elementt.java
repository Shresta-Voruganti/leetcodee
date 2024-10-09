import java.util.Hashtable;
class Solution {
    public int majorityElement(int[] nums) {
        Hashtable<Integer,Integer> checkele = new Hashtable<>();
        for(int ch : nums)
        {
            checkele.put(ch, checkele.getOrDefault(ch, 0)+1);
        }
        int n = nums.length;
        int res = 0;
        for(Map.Entry<Integer,Integer> e : checkele.entrySet())
        {
            if(e.getValue() > (int)n/2 )
            {
                res = e.getKey();
            }
        }
        return res;
    }
}

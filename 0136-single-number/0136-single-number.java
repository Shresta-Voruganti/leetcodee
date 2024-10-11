import java.util.Hashtable;
class Solution {
    public int singleNumber(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int ch : nums)
        {
            ht.put(ch, ht.getOrDefault(ch, 0)+1);
        }

        for(int ch : ht.keySet())
        {
            if(ht.get(ch) == 1)
            {
                return ch;
            }
        }
        return 0;
    }
}
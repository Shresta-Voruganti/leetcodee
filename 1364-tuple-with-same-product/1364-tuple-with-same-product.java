import java.util.Hashtable;
class Solution {
    public int tupleSameProduct(int[] nums) {
        Hashtable<Integer, Integer> ht1 = new Hashtable<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int res = nums[i] * nums[j];
                ht1.put(res, ht1.getOrDefault(res, 0) + 1);
            }
        }

        int count = 0;
        for(int freq : ht1.values()) {
            if(freq > 1) {
                count += 4 * (freq * (freq - 1));
            }
        }

        return count;
    }
}
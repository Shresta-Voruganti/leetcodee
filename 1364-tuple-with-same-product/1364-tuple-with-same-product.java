import java.util.Hashtable;
class Solution {
    public int tupleSameProduct(int[] nums) {
        Hashtable<Integer, Integer> ht1 = new Hashtable<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int res = nums[i] * nums[j];
                ht1.put(res, ht1.getOrDefault(res, 0) + 1);
            }
        }

        int count = 0;
        for(int freq : ht1.values()) {
            count += 4 * freq * (freq - 1);
        }

        return count;
    }
}
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        Hashtable<Integer, Integer> coun = new Hashtable<>();
        for(int ch : nums)
        {
            coun.put(ch, coun.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> coun.get(b)-coun.get(a));
        for(int key : coun.keySet())
        {
            heap.add(key);
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++)
        {
            result[i] = heap.poll();
        }

        return result;
    }
}
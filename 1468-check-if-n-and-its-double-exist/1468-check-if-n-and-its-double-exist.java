import java.util.Hashtable;
class Solution {
    public boolean checkIfExist(int[] arr) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i=0; i<arr.length; i++) {
            if(ht.containsKey(2*arr[i]) || arr[i]%2==0 && ht.containsKey(arr[i]/2)) {
                return true;
            }
            ht.put(arr[i],i);
        }
        return false;
    }
}
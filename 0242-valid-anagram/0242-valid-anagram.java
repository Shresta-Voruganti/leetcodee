import java.util.Hashtable;
class Solution {
    public boolean isAnagram(String s, String t) 
    {
      if(s.length() != t.length())
      {
        return false;
      }

      Hashtable<Character,Integer> checkana1 = new Hashtable<>();
      int count1 = 1;
      for(char ch1 : s.toCharArray())
      {
        checkana1.put(ch1, checkana1.getOrDefault(ch1, 0) +1);
      }
      Hashtable<Character,Integer> checkana2 = new Hashtable<>();
      int count2 = 1;
      for(char ch2 : t.toCharArray())
      {
        checkana2.put(ch2, checkana2.getOrDefault(ch2, 0) +1);
      }
    boolean areEquals = checkana1.equals(checkana2);
    return areEquals;
    }
}
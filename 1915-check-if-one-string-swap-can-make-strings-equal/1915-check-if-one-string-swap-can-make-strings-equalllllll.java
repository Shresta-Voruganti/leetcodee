import java.util.Hashtable;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        Hashtable<Character, List<Integer>> ht1 = new Hashtable<>();
        Hashtable<Character, List<Integer>> ht2 = new Hashtable<>();
        List<Integer> diffIndices = new ArrayList<>();

        for(int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            ht1.putIfAbsent(ch1, new ArrayList<>(List.of(0)));
            ht1.get(ch1).set(0, ht1.get(ch1).get(0) + 1);
            ht1.get(ch1).add(i);

            ht2.putIfAbsent(ch2, new ArrayList<>(List.of(0)));
            ht2.get(ch2).set(0, ht2.get(ch2).get(0) + 1);
            ht2.get(ch2).add(i);

            if(ch1 != ch2) {
                diffIndices.add(i);
            }
        }
        if(diffIndices.size() != 2) {
            return false;
        }

        int i = diffIndices.get(0), j = diffIndices.get(1);

        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}

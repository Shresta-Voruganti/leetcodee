class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> hcount = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hcount.put(ch, hcount.getOrDefault(ch, 0) + 1);
        }

        int delCount = 0;
        for(int freq : hcount.values()) {
            if(freq % 2 == 1) {
                delCount += freq - 1;
            }
            else {
                delCount += freq - 2;
            }
        }
        return s.length() - delCount;
    }
}
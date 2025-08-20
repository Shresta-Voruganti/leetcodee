class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        int maxx = Integer.MIN_VALUE;
        int len = num.length();
        for(int i = 0; i <= len - 3; i++) {
            String sub = num.substring(i, i + 3);
            Map<Character, Integer> hmap = new HashMap<>();
            int val = 0;
            for(char ch : sub.toCharArray()) {
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
                val = ch - '0';
            }
            if(hmap.size() == 1) {
                if(val > maxx) {
                    maxx = val;
                    max = sub;
                }
            }
        }
        return max;
    }
}
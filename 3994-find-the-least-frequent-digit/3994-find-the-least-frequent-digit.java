class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer, Integer> hmap = new HashMap<>();
        String str = Integer.toString(n);
        char[] chh = str.toCharArray();
        for(char chn : chh) {
            int d = chn - '0';
            hmap.put(d, hmap.getOrDefault(d, 0) + 1);
        }
        int min = str.length() + 1;
        int ans = 0;
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            int val = e.getValue();
            int key = e.getKey();
            if(val < min) {
                min = val;
                ans = key;
            }
        }

        return ans;
    }
}
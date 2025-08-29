class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hmap = new HashMap<>();

        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            hmap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        res.addAll(hmap.values());

        return res;
    }
}
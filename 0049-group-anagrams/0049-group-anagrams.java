class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        // Set<char[]> checks = new HashSet();
        // Map<char[], List<String>> hmap = new HashMap<>();
        Set<String> checks = new HashSet<>();
        Map<String, List<String>> hmap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            // checks.add(chs);
            checks.add(new String(chs));
        }
        // for(char[] ch : checks) {
        //     hmap.put(ch, new ArrayList<>());
        // }

        for (String key : checks) {
            hmap.put(key, new ArrayList<>());
        }

        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            // List<String> ll = hmap.get(chs);
            List<String> ll = hmap.get(key);
            ll.add(s);
            // hmap.put(chs, ll);       
            hmap.put(key, ll);     
        }

        // for(Map.Entry<char[], List<String>> e : hmap.entrySet()) {
        //     List<String> ll = e.getValue();
        //     res.add(ll);
        // }

        for (Map.Entry<String, List<String>> e : hmap.entrySet()) {
            res.add(e.getValue());
        }

        return res;
    }
}
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            String src = sources[i];
            if(s.startsWith(src, idx)) {
                hmap.put(idx, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if(hmap.containsKey(i)) {
                int index = hmap.get(i);
                sb.append(targets[index]);
                i += sources[index].length();
            }
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
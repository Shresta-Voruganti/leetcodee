class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pcnt = new int[26];
        int[] scnt = new int[26];
        int plen = p.length();
        int slen = s.length();

        if(plen > slen) return res;

        for(char ch : p.toCharArray()) {
            pcnt[ch - 'a']++;
        }

        for(int i = 0; i < plen; i++) {
            scnt[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pcnt, scnt)) res.add(0);

        for(int i = plen; i < slen; i++) {
            scnt[s.charAt(i - plen) - 'a']--;
            scnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(pcnt, scnt)) res.add(i - plen + 1);
        }

        return res;
    }
}
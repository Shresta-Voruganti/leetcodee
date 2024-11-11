class Solution {
    public String[] findWords(String[] words) {
        List<String> l = new ArrayList<>();
        Set<Character> s1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> s2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> s3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        boolean b1,b2,b3;
        for(String w : words) {
            b1 = true; b2 = true; b3 = true;
            for(int i=0; i<w.length(); i++) {
                char ch = Character.toLowerCase(w.charAt(i));
                if(!s1.contains(ch)) b1 = false;
                if(!s2.contains(ch)) b2 = false;
                if(!s3.contains(ch)) b3 = false;
            }
            if(b1 || b2 || b3) {
                l.add(w);
            }
        }
        return l.toArray(new String[0]);
    }
}
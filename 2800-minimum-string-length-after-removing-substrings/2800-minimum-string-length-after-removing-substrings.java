class Solution {
    public int minLength(String s) {
        StringBuilder smod = new StringBuilder();
        for(int i=0; i<s.length();i++) {
            smod.append(s.charAt(i));
            int x = smod.length()-1;
            if(smod.length()>=2) {
                String snew = smod.substring(x-1,x+1);
                if(snew.equals("AB") || snew.equals("CD")) {
                    smod.delete(x-1,x+1);
                }
            }
        }
        return smod.length();
    }
}
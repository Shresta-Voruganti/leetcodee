class Solution {
    public boolean isPalindrome(String s) 
    {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if(s.isEmpty())
        {
            return true;
        }
        char[] ss = s.toCharArray();
        int l = ss.length;
        for(int i=0; i<l;i++)
        {
            int t = l-1-i;
            if(ss[i]!=ss[t])
            {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        String s = String.valueOf(x);
        char[] chh = s.toCharArray();
        int[] num = new int[chh.length];
        int l = num.length;
        for(int i=0; i<l; i++)
        {
            num[i] = chh[i] - '0';
        }
        
        for(int i=0; i<l; i++)
        {
            int t = l-1-i;
            if(num[i]!=num[t])
            {
                return false;
            }
        }

        return true;
    }
}
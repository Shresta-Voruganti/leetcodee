class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) //if the string is empty or if the string has no common prefix
        {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String str : strs)
        {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isCommonPrefix(strs, mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low+(high-low)/2)-1);
    }

    private boolean isCommonPrefix(String[] strs, int len)
    {
        String str1 = strs[0].substring(0,len);
        for(int i=0; i<strs.length; i++)
        {
            if(!strs[i].startsWith(str1))
            {
                return false;
            }
        }
        return true;
    }
}

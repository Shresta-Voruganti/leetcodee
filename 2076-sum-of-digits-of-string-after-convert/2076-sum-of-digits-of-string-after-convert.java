class Solution {
    public int getLucky(String s, int k) 
    {
        String numericString = "";
        for(char ch : s.toCharArray())
        {
            numericString += Integer.toString(ch - 'a' + 1);
        }
        while(k > 0)
        {
            int digitSum = 0;
            for(char chdigit : numericString.toCharArray())
            {
                digitSum += chdigit - '0';
            }
            numericString = Integer.toString(digitSum);
            k--;
        }
        return Integer.parseInt(numericString);
    }
}
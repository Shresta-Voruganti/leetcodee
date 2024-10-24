class Solution {
    public int[] plusOne(int[] digits) {
       int n = digits.length;

       for(int i=n-1; i>=0 ;i--)
       {
            if(digits[i]<9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
       }

       // if all are 9's in the digits, so we need extra place to store 1

       int[] newdig = new int[n+1]; //elements are 0 by default
       newdig[0] = 1;
       return newdig;
       
    }
}
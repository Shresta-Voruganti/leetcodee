class Solution {
    public boolean isHappy(int n) 
    {
        boolean res = false;

        while(n!=1 && n!=4)
        {
            int sum = 0;
            while(n>0)
            {
                sum += Math.pow(n%10,2);
                n = n/10;
            }
            n = sum;
        }

        if(n==1)
        {
            res = true;
        }

        return res;
    }
}

class Solution {
    static boolean armstrongNumber(int n) {
        int sum = 0;
        int t = n;
        while(n>0)
        {
            sum+= Math.pow(n%10,3);
            n = n/10;
        }
        if(sum==t)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

class Solution {
    public int chalkReplacer(int[] chalk, int k) 
    {
        long sum = 0;
        for(int i=0; i<=chalk.length-1; i++)
        {
            sum += chalk[i];
            if(sum > k)
            {
                break;
            }
        }
        k = k % (int) sum;
        for(int i=0; i<chalk.length; i++)
        {
            if(k < chalk[i])
            {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}
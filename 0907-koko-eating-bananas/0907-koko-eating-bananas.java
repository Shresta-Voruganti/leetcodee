class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int totalhrs = calculateTotalHours(piles, mid);
            if(totalhrs <= h)
            {
                high = mid - 1; // to get minimum (k) hourly consumption value, eliminate right part 
            }
            else //totalhrs > h -> eliminate left part
            {
                low = mid + 1;
            }
        }
        return low;
    }

    public int findMax(int[] piles)
    {
        int maxo = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++)
        {
            maxo = Math.max(maxo, piles[i]);
        }
        return maxo;
    }

    public int calculateTotalHours(int[] piles, int hourly)
    {
        int totalhrs = 0;
        for(int i=0; i<piles.length; i++)
        {
            totalhrs += Math.ceil((double) piles[i]/(double) hourly);
        }
        return totalhrs;
    }
}
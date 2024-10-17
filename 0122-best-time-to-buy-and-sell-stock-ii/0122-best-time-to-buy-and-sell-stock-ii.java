class Solution {
    public int maxProfit(int[] prices) {
        int currentprofit;
        int sum = 0;
        for(int i=1; i<prices.length; i++)
        {
            currentprofit = prices[i] - prices[i-1];
            if(currentprofit>0)
            {
                sum += currentprofit;
            }
        }
        return sum;

        // int sum = 0;
        // for(int i=1; i<prices.length; i++)
        // {
        //     if(prices[i] > prices[i-1])
        //     {
        //         sum+= prices[i]-prices[i-1];
        //     }
        // }
        // return sum;

    }
}
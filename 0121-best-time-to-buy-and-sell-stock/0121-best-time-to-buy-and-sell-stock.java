class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int maxprofit = 0;
        int currentprofit;
        for(int i=0; i<prices.length; i++)
        {
            minprice = Math.min(minprice, prices[i]);
            currentprofit = prices[i]-minprice;
            maxprofit = Math.max(currentprofit, maxprofit);
        }
        return maxprofit;
    }
}
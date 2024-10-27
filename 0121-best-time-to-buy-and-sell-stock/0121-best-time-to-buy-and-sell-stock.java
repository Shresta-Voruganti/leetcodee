class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
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
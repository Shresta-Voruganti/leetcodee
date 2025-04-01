class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length;
        int nboard = 0;
        int nrotats = 0;
        int profit = 0;
        int boardingpeople = 0;
        int nwait = 0;
        int[] res = new int[2];
        int maxprofit = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            nboard = customers[i];
            if(nwait != 0) {
                nboard = nboard + nwait;
            }
            if(nboard > 4) {
                nwait = nboard - 4;
                nboard = 4;
            }
            else {
                nwait = 0;
            }
            boardingpeople += nboard;
            nrotats = nrotats + 1;
            profit = (boardingpeople * boardingCost) - (nrotats * runningCost);
            if(profit > maxprofit) {
                res[0] = profit;
                res[1] = nrotats;
                maxprofit = profit;
            }
        }
        while(nwait > 0) {
            // nboard = Math.min(nwait, 4);
            // nwait -= nboard;
            nboard = nwait;
            if (nboard > 4) {
                nwait = nboard - 4;
                nboard = 4;
            } else {
                nwait = 0;
            }
            boardingpeople += nboard;
            nrotats = nrotats + 1;
            profit = (boardingpeople * boardingCost) - (nrotats * runningCost);
            if(profit > maxprofit) {
                res[0] = profit;
                res[1] = nrotats;
                maxprofit = profit;
            }

        }
        return res[0] > 0 ? res[1] : -1;
    }
}
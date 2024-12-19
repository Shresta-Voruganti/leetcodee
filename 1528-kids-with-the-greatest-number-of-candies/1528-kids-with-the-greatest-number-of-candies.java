class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int maxnum = Integer.MIN_VALUE;
        int n = candies.length;
        for(int i=0; i<n; i++) {
            maxnum = Math.max(maxnum, candies[i]);
        }
        //we will get max candy count
        // int[] newcandies = new int[n];
        for(int i=0; i<n; i++) {
            int sum = 0;
            // newcandies[i] = candies[i] + extraCandies;
            sum = candies[i] + extraCandies;
            // if(newcandies[i] >= maxnum) {
            if(sum >= maxnum) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}
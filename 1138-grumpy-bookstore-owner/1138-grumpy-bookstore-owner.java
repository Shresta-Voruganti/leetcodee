class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        int extrasatisfied = 0;
        int maxsatisfied = 0;

        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 1) {
                extrasatisfied += customers[i];
            }

            if(i >= minutes && grumpy[i - minutes] == 1) {
                extrasatisfied -= customers[i - minutes];
            }

            maxsatisfied = Math.max(extrasatisfied, maxsatisfied);
        }

        return satisfied + maxsatisfied;
    }
}
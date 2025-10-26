class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int start = 1;

        for(int i = 1; i <= n; i++) {
            total += start + (i - 1) % 7;
            if(i % 7 == 0) start++;
        }

        return total;
    }
}
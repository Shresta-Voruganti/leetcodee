class Solution {
    public int countPrimeSetBits(int left, int right) {
        int n = right - left + 1;
        int[] res = new int[n];
        res[0] = left;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] + 1;
        }
        int c = 0;
        for(int i = 0; i < n; i++) {
//            res[i] = Integer.bitCount(res[i]);
            res[i] = countBits(res[i]);
            if(checkprimes(res[i])) {
                c++;
            }
        }
        return c;
    }

    private boolean checkprimes(int ele) {
        if(ele <= 1) return false;
        if(ele == 2 || ele == 3) return true;
        if((ele & 1) == 0) return false;

        for(int i = 3; i * i <= ele; i += 2) {
            if((ele % i) == 0) {
                return false;
            }
        }
        return true;
    }

    private int countBits(int ele) {
        int count = 0;
        while(ele > 0) {
            if((ele & 1) == 1) {
                count++;
            }
            ele = ele >> 1;
        }
        return count;
    }
}
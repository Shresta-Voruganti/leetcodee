class Solution {
    public int gcdOfOddEvenSums(int n) {
        // int so = 0;
        // int se = 0;
        // for(int i = 0; i <= n; i++) {
        //     if(i % 2 == 0) {
        //         se += i;
        //     }
        //     else {
        //         so += i;
        //     }
        // }
        // return gcd(so, se);
        int sodd = n * n;
        int seven = n * (n + 1);
        return gcd(sodd, seven);

    }

    private int gcd(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        // if(a < b) return gcd(b, a % b);
        // return gcd(a % b, b);
        return gcd(b, a % b);
    }
}
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++) {
            if(isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSymmetric(int i) {
        String s = String.valueOf(i);
        int n = s.length();
        if((n & 1) == 1) {
            return false;
        }
        int n1 = n / 2;
        int s1 = sum(0, n1, s);
        int s2 = sum(n1, n, s);
        return s1 == s2;
    }

    private int sum(int a, int b, String str) {
        int s = 0;
        for(int i = a; i < b; i++) {
            s += (str.charAt(i) - '0');
        }
        return s;
    }
}
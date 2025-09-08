class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 0;
        int b = 0;
        for(int i = 1; i < n; i++) {
            a = i;
            b = n - i;
            String str1 = Integer.toString(a);
            String str2 = Integer.toString(b);
            if(!str1.contains(String.valueOf('0')) && !str2.contains(String.valueOf('0'))) {
                return new int[]{a, b};
            }
        }
        return new int[]{a, b};
    }
}
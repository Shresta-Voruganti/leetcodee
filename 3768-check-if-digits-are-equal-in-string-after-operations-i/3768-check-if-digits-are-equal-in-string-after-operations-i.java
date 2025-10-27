class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        if(n < 3) return false;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        while(n > 2) {
            for(int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--;
        }

        return arr[0] == arr[1];
    }
}
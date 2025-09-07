class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int a = 1;
        int b = -1;
        int i = 0;
        while(i < n - 1) {
            ans[i++] = a++;
            ans[i++] = b--;
        }

        if(n % 2 == 1) {
            ans[i] = 0;
        }
        return ans;
    }
}
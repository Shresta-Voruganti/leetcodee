class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seen = new boolean[n + 1];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(seen[A[i]]) {
                count++;
            }
            else {
                seen[A[i]] = true;
            }

            if(seen[B[i]]) {
                count++;
            }
            else {
                seen[B[i]] = true;
            }
            C[i] = count;
        }
        return C;
    }
}
class Solution {
    public int[] findPermutation(String s) {
        int m = s.length();
        int n = m + 1;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            res[i] = i + 1;
        }

        int i = 0;
        while(i < m) {
            if(s.charAt(i) == 'D') {
                int j = i;
                while((j < m) && (s.charAt(j) == 'D')) {
                    j++;
                }
                reverse(res, i, j);
                i = j;
            }
            else {
                i++;
            }
        }
        return res;
    }

    private void reverse(int[] arr, int l, int r) {
        while(l < r) {
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
    }
}
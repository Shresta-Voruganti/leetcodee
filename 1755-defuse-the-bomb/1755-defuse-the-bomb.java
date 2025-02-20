class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if(k == 0) {
            Arrays.fill(res, 0);
            return res;
        }

        for(int i = 0; i < n; i++) {
            if(k > 0) {
                res[i] = sumup(n, k, i, code);
            }
            else {
                res[i] = sumdown(n, k, i, code);
            }
        }

        return res;
    }

    private int sumup(int n, int k, int index, int[] arr) {
        int sum = 0;
        int count = 0;
        int kin = index;
        for(int i = 0; i < Math.abs(k); i++) {
            if(count > k) {
                break;
            }
            kin = (kin + 1) % n;
            sum += arr[kin];
            count++;
        }
        return sum;
    }

    private int sumdown(int n, int k, int index, int[] arr) {
        int sum  = 0;
        int count = 0;
        int kin = index;
        for(int i = 0; i < Math.abs(k); i++) {
            if(count > Math.abs(k)) {
                break;
            }
            kin = (kin - 1 + n) % n;
            sum += arr[kin];
            count++;
        }
        return sum;
    }
}
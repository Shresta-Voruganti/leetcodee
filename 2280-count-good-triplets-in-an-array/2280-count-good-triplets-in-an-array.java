class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int[] pos2 = new int[n];

        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] reverse = new int[n];
        for(int i = 0; i < n; i++) {
            reverse[pos2[nums1[i]]] = i;
        }

        long count = 0;
        FenwickTree fwt = new FenwickTree(n);

        for(int i = 0; i < n; i++) {
            int pos = reverse[i];
            int left = fwt.query(pos);
            fwt.update(pos, 1);
            int right = (n - 1 - pos) - (i - left);
            count += (long) left * right;
        }
        
        return count;
    }
}

class FenwickTree {
    private int[] arr;
    public FenwickTree(int size) {
        arr = new int[size + 1];
    }

    public void update(int i, int val) {
        i++;
        while(i < arr.length) {
            arr[i] += val;
            i += i & -i;
        }
    }

    public int query(int i) {
        i++;
        int sum = 0;
        while(i > 0) {
            sum += arr[i];
            i -= i & -i;
        }
        return sum;
    }
}
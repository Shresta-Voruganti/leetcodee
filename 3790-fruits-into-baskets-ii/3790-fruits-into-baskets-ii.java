class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int[] vis = new int[n];
        int[] arr = new int[m];
        Arrays.fill(arr, 0);
        Arrays.fill(vis, 0);
        int count = n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[j] == 0 && baskets[j] >= fruits[i]) {
                    arr[j] = 1;
                    vis[i] = 1;
                    count--;
                    break;
                }
                else {
                    continue;
                }
            }
        }
        return count;
    }
}
class Solution {
    public int totalMoney(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 8; i <= n; i+=7) {
            arr[i] = arr[i - 7] + 1;
        }
        for(int i = 1; i <= n; i+=7) {
            for(int j = i + 1; j < i + 7 && j <= n; j++) {
                arr[j] = arr[j - 1] + 1;
            }
        }
        
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += arr[i];
        }

        return sum;
    }
}

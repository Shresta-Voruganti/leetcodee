class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }

        int maxlen = 0;
        int i = 0;
        boolean uphill = false;
        boolean downhill = false;
        int n = arr.length;
        
        while(i < n - 1) {
            if(arr[i] < arr[i + 1]) {
                int start = i;

                while(i < n - 1 && arr[i] < arr[i + 1]) {
                    i++;
                    uphill = true;
                }

                while(i < n - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    downhill = true;
                }

                if(uphill && downhill) {
                    maxlen = Math.max(maxlen, i - start + 1);
                }

                uphill = downhill = false;
            }

            else {
                i++;
            }
        }

        return maxlen;
    }
}
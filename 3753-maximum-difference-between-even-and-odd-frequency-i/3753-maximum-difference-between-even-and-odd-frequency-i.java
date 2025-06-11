class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++) {
            if(arr[i] > 0) {
                if(arr[i] % 2 == 0) {
                    min = Math.min(min, arr[i]);
                }
                else {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        return max - min;
    }
}
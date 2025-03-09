class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int[] res = new int[3];
        // int index = 1;
        int n = colors.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;
            res[0] = colors[prev];

            res[1] = colors[i];

            int next = (i + 1) % n;
            res[2] = colors[next];

            if(res[0] == res[2] && res[0] != res[1]) {
                count++;
            }
        }

        return count;
    }
}
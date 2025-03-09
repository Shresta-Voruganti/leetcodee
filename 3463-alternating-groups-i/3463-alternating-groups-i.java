class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;
            int next = (i + 1) % n;

            if(colors[prev] == colors[next] && colors[prev] != colors[i]) {
                count++;
            }
        }

        return count;
    }
}
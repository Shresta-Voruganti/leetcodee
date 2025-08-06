class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxarea = 0;
        while(i < j) {
            int width = j - i;
            maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * width);
            if(height[i] <= height[j]) {
                i++;
            }
            else {
                j--;
            }
        }

        return maxarea;
    }
}

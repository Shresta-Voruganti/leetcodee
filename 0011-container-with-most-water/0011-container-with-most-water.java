class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxarea = 0;
        while(i < j) {
            int area = 1;
            if(height[i] <= height[j]) {
                area = height[i] * (j - i);
                i++;
            }
            else if(height[i] > height[j]) {
                area = height[j] * (j - i);
                j--;
            }
            maxarea = Math.max(area, maxarea);
        }

        return maxarea;
    }
}
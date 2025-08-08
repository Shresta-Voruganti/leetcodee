class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= n; i++) {
            int curheight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && curheight < heights[stack.peek()]) {
                int topindex = stack.pop();
                int height = heights[topindex];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                int area = height * width;
                maxarea = Math.max(maxarea, area);
            }
            stack.push(i);
        }
        return maxarea;
    }
}
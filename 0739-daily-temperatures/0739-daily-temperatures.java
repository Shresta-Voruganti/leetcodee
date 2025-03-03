class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previndex = stack.pop();
                answer[previndex] = i - previndex;
            }
            stack.push(i);
        }

        return answer;
    }
}
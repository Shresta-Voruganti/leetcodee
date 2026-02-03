class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        for(int i = n - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if(c == '?') {
                char trueval = stack.pop();
                stack.pop();
                char falseval = stack.pop();

                i--;
                if(expression.charAt(i) == 'T') {
                    stack.push(trueval);
                }
                else {
                    stack.push(falseval);
                }
            }
            else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.pop());
    }
}
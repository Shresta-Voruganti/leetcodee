class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int operand = 0;
        char operation = '+';

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                operand = (10 * operand) + (int) (ch - '0');
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == n - 1) {
                if(operation == '+') {
                    stack.push(operand);
                }
                else if(operation == '-') {
                    stack.push(-operand);
                }
                else if(operation == '*') {
                    stack.push(stack.pop() * operand);
                }
                else if(operation == '/') {
                    stack.push(stack.pop() / operand);
                }
                operation = ch;
                operand = 0;
            }
        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
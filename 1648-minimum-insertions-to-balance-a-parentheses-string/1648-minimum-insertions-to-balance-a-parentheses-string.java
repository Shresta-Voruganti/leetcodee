class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if(i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    // i+=2;
                    i++;
                }
                else {
                    ans++;
                }

                if(stack.isEmpty()) {
                    ans++;
                }
                else {
                    stack.pop();
                }
            }
        }

        ans += stack.size() * 2;
        return ans;
    }
}
class Solution {
    public int minInsertions(String s) {
        // Stack<Character> stack = new Stack<>();
        int c = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                // stack.push(s.charAt(i));
                c++;
            }
            else {
                if(i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    i++;
                }
                else {
                    ans++;
                }

                // if(stack.isEmpty()) 
                if(c == 0) {
                    ans++;
                }
                else {
                    // stack.pop();
                    c--;
                }
            }
        }

        // ans += stack.size() * 2;
        ans += c * 2;

        return ans;
    }
}
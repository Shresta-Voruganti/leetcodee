class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k >= n) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(char digit : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        while(k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}
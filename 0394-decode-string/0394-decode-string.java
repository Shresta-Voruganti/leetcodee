class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack = new Stack<>();
        Stack<StringBuilder> stringstack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }
            else if(ch == '[') {
                countstack.push(k);
                stringstack.push(sb);
                sb = new StringBuilder();
                k = 0;
            }
            else if(ch == ']') {
                int count = countstack.pop();
                StringBuilder prev = stringstack.pop();
                for(int i = 0; i < count; i++) {
                    prev.append(sb);
                }
                sb = prev;
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
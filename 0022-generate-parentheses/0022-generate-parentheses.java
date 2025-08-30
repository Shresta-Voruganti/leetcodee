class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;        
    }

    private void backtrack(List<String> res, StringBuilder curString, int openBracketCount, int closedBracketCount, int n) {
        if(curString.length() == (2 * n)) {
            res.add(curString.toString());
            return;
        }

        if(openBracketCount < n) {
            curString.append("(");
            backtrack(res, curString, openBracketCount + 1, closedBracketCount, n);
            curString.deleteCharAt(curString.length() - 1);
        }

        if(openBracketCount > closedBracketCount) {
            curString.append(")");
            backtrack(res, curString, openBracketCount, closedBracketCount + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
}
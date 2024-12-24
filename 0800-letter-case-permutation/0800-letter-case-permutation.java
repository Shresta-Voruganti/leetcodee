class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        // Collections.sort(res);
        return res;
    }

    private void backtrack(char[] chArr, int i, List<String> res) {
        if(i == chArr.length) {
            res.add(new String(chArr));
            return;
        }

        backtrack(chArr, i+1, res);

        if(Character.isLetter(chArr[i])) {
            chArr[i] = Character.isUpperCase(chArr[i]) ? Character.toLowerCase(chArr[i]) : Character.toUpperCase(chArr[i]);
            backtrack(chArr, i+1, res);

            chArr[i] = Character.isUpperCase(chArr[i]) ? Character.toLowerCase(chArr[i]) : Character.toUpperCase(chArr[i]);
        }
    }
}
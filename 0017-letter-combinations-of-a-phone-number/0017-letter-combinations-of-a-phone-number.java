class Solution {
    static Map<String, String[]> pmap = new HashMap<>();
    static {
        pmap.put("2", new String[] {"a","b","c"});
        pmap.put("3", new String[] {"d","e","f"});
        pmap.put("4", new String[] {"g","h","i"});
        pmap.put("5", new String[] {"j","k","l"});
        pmap.put("6", new String[] {"m","n","o"});
        pmap.put("7", new String[] {"p","q","r","s"});
        pmap.put("8", new String[] {"t","u","v"});
        pmap.put("9", new String[] {"w","x","y","z"});
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        backtrack(digits.toCharArray(), 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(char[] chArr, int i, StringBuilder current, List<String> res) {
        if(i == chArr.length) {
            res.add(current.toString());
            return;
        }

        String[] letters = pmap.get(String.valueOf(chArr[i]));

        for(String letter : letters) {
            current.append(letter);
            backtrack(chArr, i+1, current, res);
            current.deleteCharAt(current.length()-1);
        }
    }
}
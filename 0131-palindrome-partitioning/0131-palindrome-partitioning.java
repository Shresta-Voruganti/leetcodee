class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(s, 0, path, res);
        return res;
    }

    private void func(String s, int index, List<String> path, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
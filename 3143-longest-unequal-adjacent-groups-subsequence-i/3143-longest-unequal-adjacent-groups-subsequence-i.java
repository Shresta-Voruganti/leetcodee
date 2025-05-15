class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        pick(0, words, groups, -1, res);
        return res;
    }

    private void pick(int index, String[] words, int[] groups, int lastpicked, List<String> res) {
        if(index == words.length) {
            return;
        }

        if(index == 0 || lastpicked != groups[index]) {
            res.add(words[index]);
            lastpicked = groups[index];
        }

        pick(index + 1, words, groups, lastpicked, res);
    }
}
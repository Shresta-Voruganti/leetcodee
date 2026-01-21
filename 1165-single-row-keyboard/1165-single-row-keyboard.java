class Solution {
    public int calculateTime(String keyboard, String word) {
        int ind = 0;
        int wl = word.length();
        int res = 0;
        for(int i = 0; i < wl; i++) {
            int index = keyboard.indexOf(word.charAt(i));
            int diff = Math.abs(ind - index);
            ind = index;
            res+= diff;
        }
        return res;
    }
}
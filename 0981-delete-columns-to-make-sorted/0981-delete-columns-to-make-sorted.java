class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int countdel = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m - 1; j++) {
                boolean check = strs[j].charAt(i) <= strs[j + 1].charAt(i);
                if(check == false) {
                    countdel++;
                    break;
                }
            }
        }
        return countdel;
    }
}
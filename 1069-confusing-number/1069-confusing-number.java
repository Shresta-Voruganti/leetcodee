class Solution {
    public boolean confusingNumber(int n) {
        char[][] mapping = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        String org = Integer.toString(n);
        StringBuilder sb = new StringBuilder();

        for(int i = org.length() - 1; i >= 0; i--) {
            boolean found = false;
            int ind = -1;
            char target = org.charAt(i);
            for(int j = 0; j < mapping.length; j++) {
                if(mapping[j][0] == target) {
                    found = true;
                    ind = j;
                    break;
                }
            }
            if(found == false) {
                return false;
            }
            sb.append(mapping[ind][1]);
        }

        String mod = sb.toString();
        int m = Integer.valueOf(mod);

        return m != n;
    }
}
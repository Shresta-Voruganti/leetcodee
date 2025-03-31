class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int subcount = 0;
        int left = 0;
        int[] freq = new int[2];

        for(int right = 0; right < s.length(); right++) {
            if(s.charAt(right) == '0') {
                freq[0]++;
            }
            else {
                freq[1]++;
            }

            while(freq[0] > k && freq[1] > k) {
                if(s.charAt(left) == '0') {
                    freq[0]--;
                }
                else {
                    freq[1]--;
                }
                left++;
            }
            subcount += (right - left + 1);
        }

        return subcount;
    }
}
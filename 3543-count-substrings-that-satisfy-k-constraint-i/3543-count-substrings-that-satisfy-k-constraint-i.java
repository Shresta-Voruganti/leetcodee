class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int subcount = 0;
        int left = 0;
        int[] freq = new int[2];

        for(int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - '0']++;

            while(true) {
                if(freq[0] <= k || freq[1] <= k) {
                    break;
                }
                freq[s.charAt(left) - '0']--;
                left++;
            }

            subcount += (right - left + 1);
        }

        return subcount;
    }
}
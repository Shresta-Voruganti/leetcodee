class Solution {
    public int numberOfSubstrings(String s) {
        if(s.length() < 3) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int[] freq = new int[3];
        for(int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            // count += (right - left + 1);
            count += left;
        }

        return count;
    }
}

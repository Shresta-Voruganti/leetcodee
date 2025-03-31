class Solution {
    public int numberOfSubstrings(String s) {
        if(s.length() < 3) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int[] freq = new int[3];
        for(int right = 0; right < s.length(); right++) {
            if(s.charAt(right) == 'a') {
                freq[0]++;
            }
            else if(s.charAt(right) == 'b') {
                freq[1]++;
            }
            else if(s.charAt(right) == 'c') {
                freq[2]++;
            }

            while(true) {
                if(freq[0] < 1 || freq[1] < 1 || freq[2] < 1) {
                    break;
                }
                if(s.charAt(left) == 'a') {
                    freq[0]--;
                }
                else if(s.charAt(left) == 'b') {
                    freq[1]--;
                }
                else if(s.charAt(left) == 'c') {
                    freq[2]--;
                }
                left++;
            }
            // count += (right - left + 1);
            count += left;
        }

        return count;
    }
}
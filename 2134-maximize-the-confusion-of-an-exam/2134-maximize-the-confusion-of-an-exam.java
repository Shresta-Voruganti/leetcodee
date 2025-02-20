class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxLength(answerKey, k, 'T'), maxLength(answerKey, k, 'F'));
    }

    private int maxLength(String answerKey, int k, char target) {
        int left = 0;
        int countOther = 0; // Count of the other character (not target)
        int maxLength = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            // If the current character is not the target, increment the count
            if (answerKey.charAt(right) != target) {
                countOther++;
            }

            // If the count of the other character exceeds k, shrink the window
            while (countOther > k) {
                if (answerKey.charAt(left) != target) {
                    countOther--;
                }
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
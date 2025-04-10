class Solution {
    private static final int MOD = 1_000_000_007; //Equivalent to 10^9 + 7
    public int maxSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        long sum1 = 0;
        long sum2 = 0;
        long result = 0;

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            }
            else {
                result += Math.max(sum1, sum2) + nums1[i];
                result %= MOD;
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while(i < n1) {
            sum1 += nums1[i];
            i++;
        }
        while(j < n2) {
            sum2 += nums2[j];
            j++;
        }

        result += Math.max(sum1, sum2);
        result %= MOD;

        return (int) result;
    }
}
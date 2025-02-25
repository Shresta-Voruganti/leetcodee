class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int l = Math.abs(nums[left]);
            int r = Math.abs(nums[right]);

            if(l < r) {
                // res.add(Math.pow(r, 2));
                res.add(r * r);
                right--;
            }
            else {
                // res.add(Math.pow(l, 2));
                res.add(l * l);
                left++;
            }
        }

        // Collections.sort(res);
        Collections.reverse(res);

        
        int[] res1 = res.stream().mapToInt(Integer::intValue).toArray();
        return res1;
    }
}
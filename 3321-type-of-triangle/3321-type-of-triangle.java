class Solution {
    public String triangleType(int[] nums) {
        int n = nums.length;
        if(n != 3) {
            return "none";
        }
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        // if((a + b <= c) || (b + c <= a) || (c + a <= b)) {
        //     return "none";
        // }
        // else {
        //     if(a == b && b == c) {
        //         return "equilateral";
        //     }
        //     else if((a == b) || (b == c) || (c == a)) {
        //         return "isosceles";
        //     }
        //     else {
        //         return "scalene";
        //     }
        // }
        if((a + b > c) && (b + c > a) && (c + a > b)) {
            if(a == b && b == c) {
                return "equilateral";
            }
            else if((a == b) || (b == c ) || (c == a)) {
                return "isosceles";
            }
            else {
                return "scalene";
            }
        }
        else {
            return "none";
        }
    }
}
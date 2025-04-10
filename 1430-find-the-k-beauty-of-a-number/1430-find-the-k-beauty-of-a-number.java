class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        int nn;
        for(int i = 0; i < k; i++) {
            sb.append(s.charAt(i));
        }
        nn = Integer.parseInt(sb.toString());
        if(isDivisor(num, nn)) {
            count++;
        }

        for(int i = k; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            nn = Integer.parseInt(sb.toString());
            if(isDivisor(num, nn)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isDivisor(int n1, int n2) {
        if(n2 == 0) {
            return false;
        }
        if(n1 % n2 == 0) {
            return true;
        }
        return false;
    }
}
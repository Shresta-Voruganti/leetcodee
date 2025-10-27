class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        if(n < 3) {
            return false;
        }        
        String res = calc(s);

        while(res.length() > 2) {
            res = calc(res);
        }

        if(res.length() == 2) {
            if((res.charAt(0) - '0') == (res.charAt(1) - '0')) {
                return true;
            }
        }

        return false;

    }

    private String calc(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i + 1 >= n) {
                continue;
            }
            int sum = (s.charAt(i) - '0') + (s.charAt(i + 1) - '0'); 
            sb.append(String.valueOf(sum % 10));
        }
        return sb.toString();
    }
}
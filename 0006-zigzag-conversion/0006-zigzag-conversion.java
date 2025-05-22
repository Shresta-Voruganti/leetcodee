class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 0) return "";
        if(numRows == 1) return s;

        int n = s.length();

        StringBuilder[] arr = new StringBuilder[numRows];
        for(int j = 0; j < numRows; j++) {
            arr[j] = new StringBuilder();
        }

        int i = 0;
        int count = 0;
        while(i < n) {
            while(count < numRows - 1 && i < n) {
                arr[count].append(s.charAt(i));
                count++;
                i++;
            }
            while(count > 0 && i < n) {
                arr[count].append(s.charAt(i));
                count--;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < numRows; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}
class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        Map<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        int count = 0;
        int sum = 0;
        int i = 0;
        while(i < n - 1) {
            if(hmap.get(s.charAt(i)) >= hmap.get(s.charAt(i + 1))) {
                sum += hmap.get(s.charAt(i));
                i++;
                count++;
            }
            else if(hmap.get(s.charAt(i)) < hmap.get(s.charAt(i + 1))) {
                int v1 = hmap.get(s.charAt(i));
                int v2 = hmap.get(s.charAt(i + 1));
                int val = v2 - v1;
                sum += val;
                i += 2;
                count += 2;
            }
        }
        if(count < n) {
            sum += hmap.get(s.charAt(n - 1));
            count++;
        }
        return sum;
    }
}
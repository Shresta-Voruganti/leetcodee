class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int i = 1;
        while(i <= n) {
            int sum = 0;
            int j = i;
            while(j > 0) {
                sum += j % 10;
                j = j/10;
            }
            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
            i++;
        }

        int count = 0;
        // int minsize = n;
        int maxsize = 0;
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            // minsize = Math.min(e.getValue(), minsize);
            maxsize = Math.max(e.getValue(), maxsize);
        }
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            if(e.getValue() == maxsize) {
                count++;
            }
        }
        return count;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        int left = 0;
        for(int right = 0; right < fruits.length; right++) {
		        // adding fruit at 'right' to hmap
            hmap.put(fruits[right], hmap.getOrDefault(fruits[right], 0) + 1);

						// if more than 2 types of fruits, shrinking window from left
            while(hmap.size() > 2) {
                if(hmap.get(fruits[left]) == 1) {
                    hmap.remove(fruits[left]);
                }
                else {
                    hmap.put(fruits[left], hmap.get(fruits[left]) - 1);
                }
                left++; // shrink window
            }
            count = Math.max(count, right - left + 1);
        }

        return count;
    }
}
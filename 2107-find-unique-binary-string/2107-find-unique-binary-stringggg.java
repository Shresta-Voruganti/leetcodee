class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Map<String, Integer> hmap = new HashMap<>();
        for(String num : nums) {
            hmap.put(num, 1);
        }

        int n = nums[0].length();

        String key = generatecodes(n, hmap);

        return key;
    }

    private String generatecodes(int n, Map<String, Integer> hmap) {
        int total = (int) Math.pow(2, n);
        String key = "";
        for(int i = 0; i < total; i++) {
            String binary = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if(!hmap.containsKey(binary)) {
                key = binary;
                break;
            }
        }

        return key;
    }
}

class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> nlist = new ArrayList<>();
        for(int num : nums) {
            nlist.add(num);
        }
        int op = 0;
        int n = nlist.size();
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        while(isthereDuplicate(hmap)) {
            if(n >= 3) {
                int o1 = nlist.get(0);
                int o2 = nlist.get(1);
                int o3 = nlist.get(2);
                nlist.remove(0);
                nlist.remove(0);
                nlist.remove(0);
                if(hmap.get(o1) == 1) {
                    hmap.remove(o1);
                }
                else {
                    hmap.put(o1, hmap.get(o1) - 1);
                }
                if(hmap.get(o2) == 1) {
                    hmap.remove(o2);
                }
                else {
                    hmap.put(o2, hmap.get(o2) - 1);
                }
                if(hmap.get(o3) == 1) {
                    hmap.remove(o3);
                }
                else {
                    hmap.put(o3, hmap.get(o3) - 1);
                }
                n -= 3;
                op++;
            }
            else {
                op++;
                break;
            }
        }

        return op;
    }

    private boolean isthereDuplicate(Map<Integer, Integer> hmap) {
        for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            if(e.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
}
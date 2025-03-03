class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> sl = new ArrayList<>();
        List<Integer> gl = new ArrayList<>();
        List<Integer> pl = new ArrayList<>();
        List<Integer> resl = new ArrayList<>();
        for(int num : nums) {
            if(num < pivot) {
                sl.add(num);
            }
            else if(num > pivot) {
                gl.add(num);
            }
            else {
                pl.add(num);
            }
        }

        for(int i = 0; i < sl.size(); i++) {
            resl.add(sl.get(i));
        }
        for(int j = 0; j < pl.size(); j++) {
            resl.add(pl.get(j));
        }
        for(int k = 0; k < gl.size(); k++) {
            resl.add(gl.get(k));
        }

        int n = resl.size();

        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = resl.get(i);
        }

        return res;
    }
}
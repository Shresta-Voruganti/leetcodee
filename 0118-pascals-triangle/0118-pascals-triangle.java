class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>(i + 1));
        }
        for(int i = 0; i < numRows; i++) {
            res.get(i).add(1);
        }
        for(int i = 1; i < numRows; i++) {
            if(i == 1) {
                res.get(i).add(1);
                continue;
            }
            for(int j = 1; j < i + 1; j++) {
                if(j == i) {
                    res.get(i).add(1);
                    continue;
                }
                res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                
            }
        }
        return res;
    }
}
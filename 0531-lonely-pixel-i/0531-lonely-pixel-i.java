class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        int m = picture.length;
        int n = picture[0].length;
        Map<Integer, List<Integer>> hmaprow = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    hmaprow.computeIfAbsent(i, k -> new ArrayList<>())
                         .add(j);
                }
            }
        }
        Map<Integer, List<Integer>> hmapcol = new HashMap<>();
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if(picture[i][j] == 'B') {
                    hmapcol.computeIfAbsent(j, k -> new ArrayList<>())
                            .add(i);
                }
            }
        }

        // int cr = hmaprow.size();
        // for(Map.Entry<Integer, List<Integer>> e : hmaprow.entrySet()) {
        //     int row = e.getKey();
        //     List<Integer> val = e.getValue();
        //     if(val.size() > 1) cr--;
        // }
        // int cc = hmapcol.size();
        // for(Map.Entry<Integer, List<Integer>> e : hmapcol.entrySet()) {
        //     int col = e.getKey();
        //     List<Integer> val = e.getValue();
        //     if(val.size() > 1) cc--;
        // }

        // count = (cr <= cc) ? cr : cc;
        
        for(Map.Entry<Integer, List<Integer>> e : hmaprow.entrySet()) {
            int row = e.getKey();
            List<Integer> val = e.getValue();

            if(val.size() == 1) {
                int col = val.get(0);

                if(hmapcol.containsKey(col) && hmapcol.get(col).size() == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
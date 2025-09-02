class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
            });
        Set<List<int[]>> hset = new HashSet<>();
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i != j) {
                    x1 = points[j][0];
                    y1 = points[j][1];
                    x2 = points[i][0];
                    y2 = points[i][1];
                    if(x1 <= x2 && y1 >= y2) {
                        boolean valid = true;
                        // int[] p1 = new int[2];
                        // int[] p2 = new int[2];
                        // p1[0] = x1; p1[1] = y1;
                        // p2[0] = x2; p2[1] = y2;
                        // List<int[]> l1 = new ArrayList<>();
                        // l1.add(p1);
                        // l1.add(p2);
                        // Collections.sort(l1, (a, b) -> {
                        //         if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                        //         return Integer.compare(a[1], b[1]);
                        // });
                        int[] p1 = {x1, y1};
                        int[] p2 = {x2, y2};
                        List<int[]> l1 = new ArrayList<>();
                        if (p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] <= p2[1])) {
                            l1.add(p1);
                            l1.add(p2);
                        } else {
                            l1.add(p2);
                            l1.add(p1);
                        }
                        for(int k = 0; k < n; k++) {
                            if(k == i || k == j) {
                                continue;
                            }
                            int x = points[k][0];
                            int y = points[k][1];
                            if(x1 <= x && x <= x2 && y2 <= y && y <= y1) {
                                valid = false;
                                break;
                            }    
                        }
                        if(valid) {
                            hset.add(l1);
                        }   
                    }
                }
            }
        }
        return hset.size();
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double passratio = 0.0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1])));


        for(int[] c : classes) pq.offer(c);

        while(extraStudents-- > 0) {
            int[] best = pq.poll();
            best[0]++;
            best[1]++;
            pq.offer(best);
        }

        for(int[] c : pq) passratio += (double) c[0]/c[1];
        return passratio/n;
    }

    private double gain(int p, int t) {
        return ((double)(p + 1)/(t + 1)) - ((double)(p)/(t));
    }
}


// class Solution {
//     public double maxAverageRatio(int[][] classes, int extraStudents) {
//         int n = classes.length;

//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
//         );

//         for (int[] c : classes) pq.offer(c);

//         while (extraStudents-- > 0) {
//             int[] best = pq.poll();
//             best[0]++; 
//             best[1]++;
//             pq.offer(best);
//         }

//         double sum = 0.0;
//         while (!pq.isEmpty()) {
//             int[] c = pq.poll();
//             sum += (double) c[0] / c[1];
//         }

//         return sum / n;
//     }

//     private double gain(int p, int t) {
//         return ((double) (p + 1) / (t + 1)) - ((double) p / t);
//     }
// }

class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        // List<Integer> costs = Arrays.asList(Arrays.stream(cost).boxed().toArray(Integer[]::new));
        // costs.sort(Collections.reverseOrder());
        
        Arrays.sort(cost);
        int ia = 0;
        int j = n - 1;
        // for (int ia = 0, j = n - 1; ia < j; ia++, j--) 
        while(ia < j) {
            int temp = cost[ia];
            cost[ia] = cost[j];
            cost[j] = temp;
            ia++;
            j--;
        }

        if(n == 2 || n == 3) {
            // return costs.get(0) + costs.get(1);
            return cost[0] + cost[1];
        }
        int sum = 0;
        /*
| Concept             | Your formula      | Java condition        |
| ------------------- | ----------------- | --------------------- |
| AP indices          | t_n = a + (n-1)d  | `i = a + (n - 1) * d` |
| Rearranged for i    | (i - a) % d == 0  | `(i - a) % d == 0`    |
| Apply only if valid | i >= a            | `i >= a`              |
        */
        int a = 2;
        int d = 3;
        for(int i = 0; i < n; i++) {
            if((i - a) % d == 0 && i >= a) {
                continue;
            }
            // sum += costs.get(i);
            sum += cost[i];
        }
        return sum;
    }
}
class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        List<Integer> costs = Arrays.asList(Arrays.stream(cost).boxed().toArray(Integer[]::new));
        costs.sort(Collections.reverseOrder());
        if(n == 2 || n == 3) {
            return costs.get(0) + costs.get(1);
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
            sum += costs.get(i);
        }
        return sum;
    }
}
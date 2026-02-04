class FirstUnique {
    Queue<Integer> q;
    Map<Integer, Integer> hmap;
    public FirstUnique(int[] nums) {
        this.q = new LinkedList<>();
        this.hmap = new HashMap<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && (hmap.get(q.peek()) > 1)) {
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peek();
    }
    
    public void add(int value) {
        hmap.put(value, hmap.getOrDefault(value, 0) + 1);
        if(hmap.get(value) == 1) {
            q.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
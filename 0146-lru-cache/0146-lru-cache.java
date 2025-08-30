class LRUCache {
    int capacity;
    Map<Integer, Integer> lhmap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        lhmap = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(lhmap.containsKey(key)) {
            int val = lhmap.get(key);
            lhmap.remove(key);
            lhmap.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(lhmap.containsKey(key)) {
            lhmap.remove(key);
        }
        else if(lhmap.size() == capacity) {
            Integer firstKey = lhmap.keySet().iterator().next();
            lhmap.remove(firstKey);
        }
        lhmap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
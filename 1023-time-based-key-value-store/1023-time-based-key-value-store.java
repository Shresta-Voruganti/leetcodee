class TimeMap {

    class Node {
        String value;
        int timestamp;

        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if(nodes == null) {
            return "";
        }
        int left = 0;
        int right = nodes.size()-1;
        String result = "";
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            Node node = nodes.get(mid);
            if(node.timestamp == timestamp) {
                return node.value;
            }
            else if(node.timestamp < timestamp) {
                result = node.value;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
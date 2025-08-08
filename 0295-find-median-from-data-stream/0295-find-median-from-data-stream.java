class MedianFinder {
    List<Integer> res;
    public MedianFinder() {
        res = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int left = 0, right = res.size();
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(res.get(mid) < num) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        res.add(left, num);
    }
    
    public double findMedian() {
        // Collections.sort(res);
        int n = res.size();
        if(n % 2 == 1) {
            return res.get(n/2);
        }
        else {
            return (res.get(n / 2 - 1) + res.get(n / 2)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
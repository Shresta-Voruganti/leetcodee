class MovingAverage {
    int k;
    int res;
    Deque<Integer> dq;

    public MovingAverage(int size) {
        this.k = size;
        this.dq = new ArrayDeque<>();
    }
    
    public double next(int val) {
        dq.addLast(val);
        res += val;

        if(dq.size() > k) {
            res -= dq.removeFirst();
        }

        return (double) res/dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
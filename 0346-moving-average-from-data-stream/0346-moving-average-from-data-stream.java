class MovingAverage {
    int k;
    int res;
    // List<Integer> resl;
    Deque<Integer> dq;

    public MovingAverage(int size) {
        this.k = size;
        // this.resl = new ArrayList<>();
        this.dq = new ArrayDeque<>();
    }
    
    public double next(int val) {
        // double avg = 0.0;
        // resl.add(val);
        dq.addLast(val);
        res += val;

        // if(resl.size() > k) 
        if(dq.size() > k) {
            // res -= resl.get(0);
            // resl.remove(0);
            res -= dq.removeFirst();
        }

        // avg = (double) res/resl.size();
        // return avg;
        // return (double) res/resl.size();
        return (double) res/dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
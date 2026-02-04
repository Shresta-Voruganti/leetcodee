class MovingAverage {
    int k;
    int res;
    List<Integer> resl;
    
    public MovingAverage(int size) {
        this.k = size;
        this.resl = new ArrayList<>();
    }
    
    public double next(int val) {
        double avg = 0.0;
        resl.add(val);
        res += val;

        if(resl.size() > k) {
            res -= resl.get(0);
            resl.remove(0);
        }

        avg = (double) res/resl.size();
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
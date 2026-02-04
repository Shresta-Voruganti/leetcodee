class MovingAverage {
    int k;
    int count;
    int res;
    List<Integer> resl;
    public MovingAverage(int size) {
        k = size;
        resl = new ArrayList<>();
    }
    
    public double next(int val) {
        double avg = 0.0;
        count++;
        if(count <= k) {
            resl.add(val);
            res += val;
            avg = (double) res/count;
        }
        if(count > k) {
            resl.add(val);
            res += val;
            int valt = resl.get(0);
            res -= valt;
            resl.remove(0);
            avg = (double) res/k;
        }
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
class SparseVector {
    Map<Integer, Integer> hmap;
    SparseVector(int[] nums) {
        hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hmap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;

        for(Integer i : this.hmap.keySet()) {
            if(vec.hmap.containsKey(i)) {
                res += this.hmap.get(i) * vec.hmap.get(i);
            }
        }

        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
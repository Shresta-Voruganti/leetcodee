class Solution {
    public long dividePlayers(int[] skill) {
        long chem = 0;
        int[] sk = skill.clone();
        Arrays.sort(sk);
        int n = sk.length;
        int[] sums = new int[n/2];
        ArrayList<int[]> pairs = new ArrayList<>();
        for(int i=0; i<n/2; i++) {
            int k = n-i-1;
            sums[i] = sk[i]+sk[k];
            pairs.add(new int[]{sk[i],sk[k]});
        }
        for(int i=0; i<sums.length-1; i++) {
            if(sums[i]!=sums[i+1]) {
                return -1;
            }
        }
        int[] chemv = new int[n/2];
        for(int i=0; i<chemv.length; i++) {
            chemv[i] = pairs.get(i)[0]*pairs.get(i)[1];
            chem += (long) chemv[i];
        }
        return chem;
    }
}

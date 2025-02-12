class Solution {
    public int minimumRecolors(String blocks, int k) {
        if(k > blocks.length()) {
            return 0;
        }
        int bcount = 0;
        int wcount = Integer.MAX_VALUE;

        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'B') {
                bcount++;
            }
        }
        wcount = Math.min(wcount, k - bcount);

        for(int i = k; i < blocks.length(); i++) {
            int outEle = blocks.charAt(i - k);
            if(outEle == 'B') {
                bcount--;
            }
            int inEle = blocks.charAt(i);
            if(inEle == 'B') {
                bcount++;
            }
            wcount = Math.min(wcount, k - bcount);
        }

        return wcount;
    }
}
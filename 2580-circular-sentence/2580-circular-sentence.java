class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sarr = sentence.split(" ");
        if(sarr.length==1) {
            return sarr[0].charAt(0)==sarr[0].charAt(sarr[0].length()-1);
        }

        for(int i=0; i<sarr.length-1; i++) {
            if(sarr[i].charAt(sarr[i].length()-1)!=sarr[i+1].charAt(0)) {
                return false;
            }
        }
        return sarr[sarr.length-1].charAt(sarr[sarr.length-1].length()-1) == sarr[0].charAt(0);
    } 
}
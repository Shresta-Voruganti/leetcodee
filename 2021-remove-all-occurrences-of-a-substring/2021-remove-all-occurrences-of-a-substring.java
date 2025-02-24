class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        
        // if(sb.toString().contains(part)) 
        while(sb.toString().contains(part)) {
            int index = sb.indexOf(part);
            sb.delete(index, index + part.length());
            // sb = new StringBuilder(removeOccurrences(sb.toString(), part));

        }
        return sb.toString();
    }
}
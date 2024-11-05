class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) {
            return false;
        }
        String cc = s+s;
        return cc.contains(goal);
    }
}
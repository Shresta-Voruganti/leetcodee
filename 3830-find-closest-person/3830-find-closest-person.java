class Solution {
    public int findClosest(int x, int y, int z) {
        int dx = Math.abs(z - x);
        int dy = Math.abs(z - y);
        
        if(dx < dy) return 1;
        else if(dy < dx) return 2;
        else return 0;
    }
}
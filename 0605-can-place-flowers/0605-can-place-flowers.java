class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i]==0) {
                boolean leftEmpty = (i==0 || flowerbed[i-1] == 0);
                boolean rightEmpty = (i==flowerbed.length-1 || flowerbed[i+1] == 0);
                if(leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if(n==0) {
                        return true;
                    }
                    i++;
                }
            }
        }
        return n<=0;
    }
}
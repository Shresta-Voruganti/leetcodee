/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while(low<=high) {
            int mid = low + (high-low)/2;
            int hint = guess(mid);
            if(hint==0) { //num==pick, i.e., guess(mid) = n
                return mid;
            }
            else if(hint==1) { //num < pick, i.e., guess(mid) < n
                low = mid+1;
            }
            else { //nums > pick, i.e., guess(mid) > n
                high = mid-1;
            }
        }
        return -1;
    }
}
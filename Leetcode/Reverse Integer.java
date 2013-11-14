public class Solution {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        long y = 0;
        while(x != 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return (int)y;
    }
}
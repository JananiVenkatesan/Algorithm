/*

Problem:
    Determine whether an integer is a palindrome. Do this without extra space.


Solution 1:

*/

public class Solution {
    public boolean isPalindrome(int x){
        if(x < 0)
            return false;
        // Record the total number of digits
        int div = 10;
        while(x / div >= 10)
            div *= 10;
        // Loop the number
        while(x >= 10){
            int left = x / div;
            int right = x % 10;
            if(left != right){
                return false;
            }
            // Trim the most left and the most right digits
            x = (x % div) / 10;
            // Decrease the total number of digits
            div = div / 100;
        }
        return true;
    }
}

/*

Solution 2:

*/

public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(x < 0)
            return false;
            
        int n = x;
        long y = 0;
        while(n != 0){
            y = y * 10 + n % 10;
            n = n / 10;
        }
        if(x == (int)y){
            return true;
        }else{
            return false;
        }
    }
}
/*

Problem:
    Given a number represented as an array of digits, plus one to 
the number.

*/


public class Solution {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(digits == null)
            return null;
        // Initiate carry = 1 as plus one
        int carry = 1; 
        for(int i = digits.length - 1; i >= 0; i --){
            digits[i] = digits[i] + carry;
            if(digits[i] >= 10){
                carry = 1;
                digits[i] = 0;
            }else{
                carry = 0;
            }
        }
        // If, at last, carry = 1, it indicates digits = 10^n - 1, so return 10^n
        if(carry == 1){
            int[] n = new int[digits.length + 1];
            for(int i : n){
                i = 0;
            }
            n[0] = 1;
            return n;
        }
        return digits;
    }
}
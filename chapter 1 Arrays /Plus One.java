/*
Problem:
    Given a number represented as an array of digits, plus one to 
the number.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null)
            return null;
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i --){
            digits[i] += carry;
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            }
            else{
                carry = 0;
            }
        }

        // If, at last, carry = 1, it indicates digits = 10^n - 1, so return 10^n
        if(carry == 1){
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}





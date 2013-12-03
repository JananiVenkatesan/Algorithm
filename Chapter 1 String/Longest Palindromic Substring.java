/*

    Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists 
one unique longest palindromic substring.

*/

public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null)
            return null;
        if(s == "" || s.length() == 1)
            return s;
        String max = "";
        for(int i = 0; i < s.length(); i ++){
            String temp = checkPalindrome(s, i, i);
            if(temp.length() > max.length())
                max = temp;
        }
        for(int i = 1; i < s.length(); i ++){
            String temp = checkPalindrome(s, i - 1, i);
            if(temp.length() > max.length())
                max = temp;            
        }
        return max;
        
    }

    public String checkPalindrome(String s, int low, int high){
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            low --;
            high ++;
        }
        return s.substring(low + 1, high);
    }
}
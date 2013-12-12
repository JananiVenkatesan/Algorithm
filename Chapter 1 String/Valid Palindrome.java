/*

    Given a string, determine if it is a palindrome, considering 
only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note: !!!!!
    Have you consider that the string might be empty? This is a
good question to ask during an interview.

    For the purpose of this problem, we define empty string as 
valid palindrome.

*/

public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null)
            return false;
        if(s.equals(""))
            return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(!isChar(s.charAt(i)) && i < j)
                i ++;
            while(!isChar(s.charAt(j)) && i < j)
                j --;
            if(isChar(s.charAt(j)) && isChar(s.charAt(i)) && s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;  // IMPORTANT! Don't forget to move cursors!
            j --;
        }
        return true;
    }
    public boolean isChar(char c){
        if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9')){
            return true;
        }else{
            return false;
        }
    }
}
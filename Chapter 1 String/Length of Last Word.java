/*
    Given a string s consists of upper/lower-case alphabets and 
    empty space characters ' ', return the length of last word 
    in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of 
    non-space characters only.

    For example, 
    Given s = "Hello World",
    return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null)
            return 0;
        s = s.trim();
        if(s.equals(""))
            return 0;
        int i = s.length() - 1;
        int count = 0;
        while(i >= 0){
            if(s.charAt(i) == ' ')
                break;
            count ++;
            i --;
        }
        return count;
    }
}
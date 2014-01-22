/*
iven s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if((s1.length() + s2.length()) != s3.length())
            return false;
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3){
        if(i1 == s1.length() - 1 && i2 == s2.length() - 1 && i3 == s3.length() - 1){
            return true;
        }
        
        boolean flag = false;
        if(i1 < s1.length() - 1 && s3.charAt(i3) == s1.charAt(i1)){
            flag = flag || isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
        }
        if(i2 < s2.length() - 1 && s3.charAt(i3) == s2.charAt(i2)){
            flag = flag || isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        return flag;
    }
}





public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if((s1.length() + s2.length()) != s3.length())
            return false;
            
        return isInterleave_2(s1, s2, s3);
    }
    
    private boolean isInterleave_2(String s1, String s2, String s3){
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
            return true;
        }
        
        boolean flag = false;
        if(s1.length() > 0 && s3.charAt(0) == s1.charAt(0)){
            flag = flag || isInterleave_2(s1.substring(1), s2, s3.substring(1));
        }
        if(s2.length() > 0 && s3.charAt(0) == s2.charAt(0)){
            flag = flag || isInterleave_2(s1, s2.substring(1), s3.substring(1));
        }
        return flag;
    }
}
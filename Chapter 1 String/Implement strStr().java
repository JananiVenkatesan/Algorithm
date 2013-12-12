/*
    Implement strStr().

    Returns the index that a substring first time appears in a string
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle == null || haystack.length() < needle.length())
            return null;
        if(needle.length() == 0)
            return haystack;
            
        for(int i = 0; i < haystack.length() - needle.length() + 1; i ++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(contains(haystack, needle, i));
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
    
    public boolean contains(String haystack, String needle, int i){
        for(int j = 0; j < needle.length(); j ++, i++){
            if(haystack.charAt(i) !=  needle.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle == null || haystack.length() < needle.length())
            return null;
        if(needle.length() == 0)
            return haystack;
            
        for(int i = 0; i < haystack.length() - needle.length() + 1; i ++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int index = isContained(haystack, needle, i);
                if(index == 1){
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
    
    public int isContained(String haystack, String needle, int i){
        for(int j = 0; j < needle.length(); j ++, i++){
            if(haystack.charAt(i) !=  needle.charAt(j)){
                return - 1;
            }
        }
        return 1;
    }
}
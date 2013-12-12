public class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
            return null;
        if(s.length() <= 1)
            return s;

        String max = "";  // IMPORTANT!  Cannot define String max = null
                          // or max.length() > temp.length() cannot be executed
        for(int i = 0; i < s.length(); i ++){
            String temp = checkPalindrome(s, i, i);
            max = max.length() > temp.length() ? max : temp;
        }
        for(int i = 1; i < s.length(); i ++){
            String temp = checkPalindrome(s, i - 1, i);
            max = max.length() > temp.length() ? max : temp;            
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
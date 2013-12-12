import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args){
        String str = "I have 36 books, 40 pens2, and 1 notebook.";
        Solution s = new Solution();
        System.out.println(s.stringReverse(str));
        // "I evah 36 skoob, 40 2snep, dna 1 .koobeton"
    }
}

class Solution{
    public String stringReverse(String s){
        if(s == null)
            return null;
        if(s.length() <= 1)
            return s;
        
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for(int index = 0; index < s.length(); index ++){
            if(!isLetter(s.charAt(index)) && !isNumber(s.charAt(index))){
                sb.append(s.charAt(index));
                continue;
            }

            cur = index;
            boolean isNumber = true;
            while(cur < s.length()){
                if(!isLetter(s.charAt(cur)) && !isNumber(s.charAt(cur)))
                    break;

                if(!isNumber(s.charAt(cur))){
                    isNumber = false;
                }
                cur ++;
            }

            if(isNumber){
                sb.append(s.substring(index, cur));
            }
            else{
                sb.append(reverse(s.substring(index, cur)));
            }
            index = cur - 1; // REMEMBER to go back 1 position! Because index ++ will always happen!
        }
        return sb.toString();
    }

    public boolean isNumber(char ch){
        return ('0' <= ch && ch <= '9');
    }

    public boolean isLetter(char ch){
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

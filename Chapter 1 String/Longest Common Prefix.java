/*
    Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {  
        if(strs == null || strs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < strs[0].length(); index ++){
            char ch = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i ++){
                // IMPORTANT!!!  index >= strs[i].length()
                if(index >= strs[i].length() || strs[i].charAt(index) != ch)
                    return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }  
}

/*

Test cases:

Input                    Output  Expected
[]                           ""  ""
[""]                         ""  ""
["a"]                        "a" "a"
["",""]                      ""  ""
["","b"]                     ""  ""
["a","b"]                    ""  ""
["c","c"]                    "c" "c"
["a","a"]                    "a" "a"
["aa","aa"]                  "aa""aa"
["aa","ab"]                  "a" "a"
["aa","a"]                   "a" "a"
["ab","ac"]                  "a" "a"
["","",""]                   ""  ""
["a","a","b"]                ""  ""
["a","b","c"]                ""  ""
["a","a","a"]                "a" "a"
["aaa","aa","aaa"]           "aa""aa"
["abab","aba",""]            ""  ""
["abab","aba","abc"]         "ab""ab"
["flower","flow","flight"]   "fl""fl"

*/
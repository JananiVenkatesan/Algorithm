// DP
public class Solution {
    public boolean wordBreak(String s, Set<String> dict){
        int max = 0, min = Integer.MAX_VALUE;
        for(String s : dict){
            max = Math.max(max, s.length());
            min = Math.min(min, s.length());
        }

        HashSet<String> unmatched = new HashSet<String>();
        return wordBreak(s, dict, unmatched, max, min);
    }
    public boolean wordBreak(String s, Set<String> dict, HashSet<String> unmatched, int max, int min) {
        if(s == null || s.length() == 0)
            return true;
        
        for(int i = 1; i <= s.length(); i ++){
            if(i <)
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                
                String suffix = s.substring(i);
                if(unmatched.contains(suffix)){
                    continue;
                }
                else{
                    if(wordBreak(suffix, dict, unmatched))
                        return true;
                    else
                        unmatched.add(suffix);
                }
            }
        }
        return false;
    }
}

// dict中的单词有的长有的短，当prefixstr串小于最短串时就不匹配了，当prefixstr串大于最长的串时也不用匹配了
// Recursive
public class Solution {
    public boolean wordBreak(String s, Set<String> dict){
        if(s == null || s.length() == 0)
            return true;
        for(int i = 1; i < s.length(); i ++){
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                if(wordBreak(s.substring(i), dict))
                    return true;
            }
        }
        return false;
    }
}


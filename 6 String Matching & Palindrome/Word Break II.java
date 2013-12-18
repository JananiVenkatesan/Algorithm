/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0 || dict.size() == 0 || dict == null)
            return list;
        Set<String> unmatched = new HashSet<String>();
        LinkedList<String> combination = new LinkedList<String>();
        wordBreak(s, dict, unmatched, combination, list);
        return list;
    }
    
    private void wordBreak(String s, Set<String> dict, Set<String> unmatched, LinkedList<String> combination, ArrayList<String> list){
        if(s == null || s.length() == 0){
            list.add(listToString(combination));
            return;
        }
        
        for(int i = 1; i <= s.length(); i ++){
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                combination.add(prefix);
                String suffix = s.substring(i);
                if(unmatched.contains(suffix)){
                    combination.removeLast();
                    continue;
                }
                else{
                    int size = list.size();
                    wordBreak(suffix, dict, unmatched, combination, list);
                    if(size == list.size()){
                        unmatched.add(suffix);
                    }
                    combination.removeLast();
                }
            }
        }
        
    }
    
    private String listToString(LinkedList<String> combination){
        StringBuilder sb = new StringBuilder();
        for(String word : combination){
            sb.append(word + " ");
        }
        return sb.toString().trim();
    }
}


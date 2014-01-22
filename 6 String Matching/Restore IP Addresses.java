/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> lists = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12)
            return lists;
        ArrayList<String> combination = new ArrayList<String>();
        restoreIP(s, combination, lists, 1);
        return lists;
    }
    
    private void restoreIP(String s, ArrayList<String> combination, ArrayList<String> lists, int level){
        if(level == 4){
            if(isValid(s)){
                combination.add(s);
                lists.add(listToString(combination));
                combination.remove(combination.size() - 1);
            }
            return;
        }
        
        for(int i = 1 ; i <= 3 && i < s.length(); i ++){  // IMPORTANT!!! i不仅要小于3，还要 i < s.length() ！！
            String pre = s.substring(0, i);
            if(isValid(pre)){
                combination.add(pre);
                String suffix = s.substring(i);
                restoreIP(suffix, combination, lists, level + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
    /*
    A valid field of an IP address is
        - 1-3 digits (as stated above)
        - between 0 and 255, inclusively
        - not prefixed with "00", can only be "0"
    */ 
    private boolean isValid(String s){
        if(s == null)
            return false;
        if(s.length() == 1 || (s.length() > 0 && s.length() < 4 && !s.startsWith("0")) ){
            int number = Integer.parseInt(s);
            if(number >= 0 && number <= 255)
                return true;
        }
        return false;
    }
    
    private String listToString(ArrayList<String> combination){
        StringBuilder sb = new StringBuilder();
        for(String s : combination){
            sb.append(s + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
/*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
*/
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
            return list;
        ArrayList<String> combination = new ArrayList<String>();
        partition(s, combination, list);
        return list;
    }
    
    private void partition(String s, ArrayList<String> combination, ArrayList<ArrayList<String>> list){
        if(s == null || s.length() < 1){
            ArrayList<String> l = copyArrayList(combination); // IMPORTANT!!! 否则list里存的是combination的地址
            list.add(l);
            return;
        }
        
        for(int i = 0; i < s.length(); i ++){
            int left = 0, right = i;
            while(left < right){
                if(s.charAt(left) == s.charAt(right)){
                    left ++;
                    right --;
                }
                else{
                    break;
                }
            }
            if(left >= right){
                
                combination.add(s.substring(0, i + 1));
                partition(s.substring(i + 1), combination, list);
                combination.remove(combination.size() - 1);
            }
        }
    }
    private ArrayList<String> copyArrayList(ArrayList<String> combination){
        ArrayList<String> l = new ArrayList<String>();
        for(String s : combination){
            l.add(s);
        }
        return l;
    }
}
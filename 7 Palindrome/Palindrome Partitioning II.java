/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        int cut = 0;
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, Integer> count = new HashMap<String,Integer>();
        int min = partition(s, list, count);
        return min;
    }
    
    public int partition(String s, LinkedList<String> list, HashMap<String, Integer> count){
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int min = 0; 
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
                int c = 0;
                String suffix = s.substring(i + 1);
                if(count.containsKey(suffix)){
                    c = list.size() + count.get(suffix);
                }
                else{
                    list.add(s.substring(0, i + 1));
                    c = partition(suffix, list, count);
                    count.put(suffix, c);
                    list.removeLast();
                }
                min = min > c ? c : min;
            }
        }
        return min;
    }
}

// Recursive
public class Solution {
    public int minCut(String s) {
        int cut = 0;
        LinkedList<String> list = new LinkedList<String>();
        partition(s, cut, list);
        return cut;
    }
    
    public void partition(String s, int cut, LinkedList<String> list){
        if(s == null || s.length() == 0){
            int c = list.size() - 1;
            if(c < cut)
                cut = c;
            return;
        }
        
        for(int i = 0; i < s.length(); i ++){
            int left = 0, right = i;
            while(left < right){
                if(s.charAt(left) == s.charAt(right)){
                    left ++;
                    right --;
                }
                else
                    break;
            }
            if(left >= right){
                list.add(s.substring(0, i + 1));
                partition(s.substring(i + 1), cut, list);
                list.removeLast();
            }
        }
    }
}
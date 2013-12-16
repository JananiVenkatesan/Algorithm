// Array
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null)
            return new ArrayList<ArrayList<Integer>>();
        return permute(num, 0);
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num, int index){
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        if(index == num.length){
            permutations.add(new ArrayList<Integer>());
        }
        else{
            ArrayList<ArrayList<Integer>> perms = permute(num, index + 1);
            int n = num[index];
            for(ArrayList<Integer> perm : perms){
                for(int i = 0; i <= perm.size(); i ++){
                    ArrayList<Integer> p = new ArrayList<Integer>();
                    p.addAll(perm);
                    p.add(i, n);
                    permutations.add(p);
                }
            }
        }   
        return permutations;
    }
}


// String
public ArrayList<String> getPerms(String s){
    if(s == null)
        return null;
    ArrayList<String> permutations = new ArrayList<String>();
    if(s.length() == 0){
        permutations.add("");
    }
    else{
        ArrayList<String> perms = getPerms(s.substring(1));
        char ch = s.charAt(0);
        for(ArrayList<String> perm : perms){
            for(int i = 0; i <= perm.length(); i ++){
                String p = insertCharAt(perm, ch, i);
                permutations.add(p);
            }
        }
    }
    return permutations;
}

public String insertCharAt(String word, char ch, int index){
    String first = word.substring(0, index);
    String second = word.substring(index);
    return first + ch + second;
}

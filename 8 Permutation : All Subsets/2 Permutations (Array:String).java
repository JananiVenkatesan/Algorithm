/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// Array
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null)
            return new ArrayList<ArrayList<Integer>>();
        return permute(num, 0);
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num, int index){
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();

        // If index points to the end of the array, create an empty LinkedList
        if(index == num.length){
            permutations.add(new ArrayList<Integer>());
        }
        else{   // Else
            // Get all permutations with (index+1) ~ (num.length-1) elements
            ArrayList<ArrayList<Integer>> perms = permute(num, index + 1);

            // Get n - the integer with index
            int n = num[index];

            // Loop all permutations with (index+1) ~ (num.length-1) elements
            for(ArrayList<Integer> perm : perms){
                // Add n to each interval between elements in the existing permutation
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


------------------LinkedList--------------------

    public static LinkedList<LinkedList<Integer>> allPermutation(int total){
        if(total < 1){
            return new LinkedList<LinkedList<Integer>>();
        }
        
        // Create an array of vertices index
        int num[] = new int[total];
        for(int i = 0; i < total; i ++){
            num[i] = i;
        }
        return allPermutation(num, 0);
    }
    
    public static LinkedList<LinkedList<Integer>> allPermutation(int[] num, int index){
        LinkedList<LinkedList<Integer>> permutations = new LinkedList<LinkedList<Integer>>();
        
        // If index points to the end of the array, create an empty LinkedList
        if(index == num.length){
            permutations.add(new LinkedList<Integer>());
        }
        else{  // Else
            // Get all permutations with (index+1) ~ (num.length-1) elements
            LinkedList<LinkedList<Integer>> perms = allPermutation(num, index + 1);
            // Get n - the integer with index
            int n = num[index];
            // Loop all permutations with (index+1) ~ (num.length-1) elements
            for(LinkedList<Integer> perm : perms){
                // Add n to each interval between elements in the existing permutation
                for(int i = 0; i <= perm.size(); i ++){
                    LinkedList<Integer> p = new LinkedList<Integer>();
                    p.addAll(perm);
                    p.add(i, n);
                    permutations.add(p);
                }
            }
        }
        
        return permutations;
    }
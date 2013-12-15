/*

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> getPermutations(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length < 1){
            return results;
        }
        if(num.length == 1){
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            results.add(perm);
            return results;
        }
        for(int i = 0; i < num.length; i ++){
            int[] subset = new int[num.length - 1];
            for(int j = 0; j < i; j ++){
                subset[j] = num[j];
            }
            for(int j = i + 1; j < num.length; j ++){
                subset[j - 1] = num[j];
            }
            for(ArrayList<Integer> perm : getPermutations(subset)){
                perm.add(num[i]);
                results.add(perm);
            }
        }
        return results;
    }
}

/*

    Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
    [1,1,2], [1,2,1], and [2,1,1].

    Alternatively, we can modify the algorithm above so that it can 
be tolerant to numbers with duplicates.

    To do that, we can add a hash table which stores the numbers 
having been visited. If we hit a number that has been visited, simple 
skip it. That only takes O(1) time.

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length < 1){
            return results;
        }
        if(num.length == 1){
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            results.add(perm);
            return results;
        }
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i ++){
            if(hm.get(num[i]) != null)
                continue;
            hm.put(num[i], true);
            int[] subset = new int[num.length - 1];
            for(int j = 0; j < i; j ++){
                subset[j] = num[j];
            }
            for(int j = i + 1; j < num.length; j ++){
                subset[j - 1] = num[j];
            }
            for(ArrayList<Integer> perm : permuteUnique(subset)){
                perm.add(num[i]);
                results.add(perm);
            }
        }
        return results;
    }
}
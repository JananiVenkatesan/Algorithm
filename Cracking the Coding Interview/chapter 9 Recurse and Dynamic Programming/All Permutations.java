/*


Problem:  Permutations
    Permutations (no duplicates)

    Given a collection of numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    

Solution:

    Permutations of n numbers can be computed based on permutations of 
n-1 numbers in the following way:

    - Select one number, i, from n of them.
    - Compute permutations of the rest n-1 numbers.
    - Append i to the end of each permutation computed in above step. 
Note that adding a number to the end of array takes time O(1) while adding 
to the beginning takes time O(n).
    

    This algorithm runs in time O(n!) which is the size of the results.

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num.length < 1){
            return results;
        }
        if(num.length == 1){
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            results.add(perm);
            return results;
        }
        for(int i = 0; i < num.length; i++){
            // copy a new array of n-1 numbers  
            int[] subset = new int[num.length - 1];
            for(int j = 0; j < i; j++){
                subset[j] = num[j];
            }
            for(int j = i + 1; j < num.length; j++){
                subset[j - 1] = num[j];
            }
            // append the current number to the end of pernutations of n-1 subset  
            for(ArrayList<Integer> perm : permute(subset)){
                perm.add(num[i]); // append to the end, O(1) 
                results.add(perm);
            }
        }
        return results;
    }
}






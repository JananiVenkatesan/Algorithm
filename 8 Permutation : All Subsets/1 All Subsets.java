/*
Problem:
	Write a method to return all subsets of a set.

Solution #1:  Recursion
	page 322

	This solution will be 0(2n) in time and space, which is the best 
we can do. For a slight optimization, we could also implement this 
algorithm iteratively.
*/

import java.util.*;

class Solution{
	public ArrayList<ArrayList<Character>> getSubsets(ArrayList<ArrayList<Character>> set){
        if(set == null || set.length == 0){
            return new ArrayList<ArrayList<Character>>;
        }
        return getSubsets(set, 0);
    }

    private ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set, int index){
        ArrayList<ArrayList<Character>> allSubsets = new ArrayList<ArrayList<Character>>();
        if(index == set.size()){
            allSubsets.add(new ArrayList<Character>());
        }
        else{
            allSubsets = getSubsets(set, index + 1);
            char ch = set.get(index);
            ArrayList<ArrayList<Character>> more = new ArrayList<ArrayList<Character>>();
            for(ArrayList<Character> subset : allSubsets){
                ArrayList<Character> newSubset = new ArrayList<Character>();
                newSubset.addAll(subset);
                newSubset.add(ch);
                more.add(newSubset);
            }
            allSubsets.addAll(more);
        }
        return allSubsets;
    }
}

public class AllSubsets{
	public static void main(String[] args){
		ArrayList<Character> set = new ArrayList<Character>();
		set.add('a');
		set.add('b');
		set.add('c');

		Solution s = new Solution();
		System.out.println(s.getSubsets(set));

	}
}

//	Solution #2:  Combinatorics
import java.util.*;

class Solution{
    public ArrayList<ArrayList<Character>> getSubsetCombinatorics(ArrayList<Character> set){
        ArrayList<ArrayList<Character>> allSubsets = new ArrayList<ArrayList<Character>>();
        int max = 1 << set.size();
        for(int i = 0; i < max; i ++){
            ArrayList<Character> subset = convertCharToSet(set, i);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    public ArrayList<Character> convertCharToSet(ArrayList<Character> set, int x){
        ArrayList<Character> subset = new ArrayList<Character>();
        int index = 0;
        for(int i = x; i > 0; i >>= 1){
            if((i & 1) == 1)
                subset.add(set.get(index));
            index ++;
        }
        return subset;
    }
}

public class Leetcode{
    public static void main(String[] args){
        //String str = "abc";
        ArrayList<Character> set = new ArrayList<Character>();
        set.add('a');
        set.add('b');
        set.add('c');
        Solution s = new Solution();
        System.out.println(s.getSubsetCombinatorics(set));
    }
}

/*
Follow up:
	Elements in a subset must be in non-descending order.

E.g.	
	If S = [1,2,3], a solution is:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S == null || S.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        return subsets(S, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        if(index == S.length){
            allSubsets.add(new ArrayList<Integer>());
        }
        else{
            allSubsets = subsets(S, index + 1);
            int i = S[index];
            ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(i);
                Collections.sort(newSubset);
                more.add(newSubset);
            }
            allSubsets.addAll(more);
        }
        return allSubsets;
    }
}

// Combinatorics
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0)
            return allSubsets;
        int max = 1 << S.length;
        for(int i = 0; i < max; i ++){
            allSubsets.add(convertToSubset(S, i));
        }
        return allSubsets;
    }
    
    private ArrayList<Integer> convertToSubset(int[] S, int x){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int i = x; i > 0; i >>= 1){
            if( (i & 1) == 1){
                subset.add(S[index]);
            }
            index ++;
        }
        Collections.sort(subset);
        return subset;
    }
}





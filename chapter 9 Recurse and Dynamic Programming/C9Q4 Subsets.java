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
	public ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set){
		if(set == null)
			return null;
		return getSubsets(set, 0);
	}

	public ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set, int index){
		ArrayList<ArrayList<Character>> allSubsets;
		if(set.size() == index){   // Base case (set.size() = index) - add empty set
			allSubsets = new ArrayList<ArrayList<Character>>();
			allSubsets.add(new ArrayList<Character>());   // empty set
		}
		else{
			allSubsets = getSubsets(set, index + 1);
			// Get one more element
			char ch = set.get(index);
			ArrayList<ArrayList<Character>> moreSubsets = new ArrayList<ArrayList<Character>>();
			for(ArrayList<Character> subset : allSubsets){
				ArrayList<Character> newSubset = new ArrayList<Character>();
				newSubset.addAll(subset);
				newSubset.add(ch);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
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

/*
	Solution #2:  Combinatorics
*/


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











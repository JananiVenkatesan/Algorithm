/*
Problem:
	Write a method to return all subsets of a set.

Solution #1:  Recursion
	page 322

	This solution will be 0(2n) in time and space, which is the best 
we can do. For a slight optimization, we could also implement this 
algorithm iteratively.
*/

ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
	
	ArrayList<ArrayList<Integer>> allsubsets;
	
	if(set.size() == index){  // Base case (set.size() = index = 0) - add empty set
		allsubsets = new ArrayList<ArrayList<Integer>>();
		allsubsets.add(new ArrayList<Integer>());   // Empty set
	}else{
		allsubsets = getSubsets(set, index + 1);
		// Get one more element
		int item = set.get(Index);
		// Create the next level of subset
		ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>(); 
		for(ArrayList<Integer> subsets : allsubsets){
			// Get every existing subset
			ArrayList<Integer> newsubsets = new ArrayList<Integer>();
			newsubsets.addAll(subset);
			// add the element to every existing subset
			newsubsets.add(item);
			// add the new subsets to moresubsets to form the next level of sebset
			moresubsets.add(newsubsets);
		}
		// add the next level of subset to all subsets
		allsubsets.addAll(moresubsets);
	}
	return allsubsets;
}

/*
Solution #2:  Combinatorics

*/











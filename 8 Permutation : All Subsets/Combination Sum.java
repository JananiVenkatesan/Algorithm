/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
	All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	Arrays.sort(candidates);
	combinationSum(candidates, 0, target, new ArrayList<Integer>(), lists);
	return lists;
}

private void combinationSum(int[] candidates, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> lists){
	if(start < 0 || target < 0)
		return;

	if(target == 0){
		ArrayList<Integer> l = new ArrayList<Integer>(path);
		lists.add(l);
	}
	else{
		for(int i = start; i < candidates.length && candidates[i] <= target; i ++){
			path.add(candidates[i]);
			combinationSum(candidates, i, target - candidates[i], path, lists);
			path.remove(path.size() - 1);
		}
	}
}
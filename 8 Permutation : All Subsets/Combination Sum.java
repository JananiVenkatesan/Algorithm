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
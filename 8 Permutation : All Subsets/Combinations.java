public ArrayList<ArrayList<Integer>> combine(int n, int k){
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	combine(1, n, k, new ArrayList<Integer>(), lists);
	return lists;
}

private void combine(int start, int n, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> lists){
	if(n == 0)
		return;
	if(k == 0){
		ArrayList<Integer> l = new ArrayList<Integer>(path);
		lists.add(l);
		return;
	}

	for(int i = start; i <= n - k + 1; i ++){
		path.add(i);
		combine(i + 1, n, k - 1, path, lists);
		path.remove(path.size() - 1);
	}
}




/* Solution 2:

Alternatively, we can think it in a "backward" way.
Given n=4 and k=2, a solution is [[4,1], [4,2], [4,3], [3,1], [3,2], [2,1]].
Generalizing to all n's and k's, we have a set of
	Append n to the result of combine(n-1, k-1);
	Append n-1 to the result of combine(n-2, k-2);
	... ...
	Append k-1 to the result of combine(n-k+1, 1), i.e. (1, 2, ..., k).
*/
public ArrayList<ArrayList<Integer>> combine(int n, int k){
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	if(k == 1){
		for(int i = 1; i <= n; i ++){
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(i);
			lists.add(l);
		}
		return lists;
	}

	for(int i = n; i >= k; i --){
		ArrayList<ArrayList<Integer>> list = combine(i - 1, k - 1);
		for(ArrayList<Integer> l : list){
			l.add(i);
			lists.add(l);
		}
	}
	return lists;
}
















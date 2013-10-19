/*
Problem:
	You are given a binary tree in which each node contains a value. 
Design an algorithm to print all paths which sum to a given value. The
path does not need to start or end at the root or a leaf.

Solution:
	page 237

	Well,if a node is at level r, we do r amount of work (that's in 
the looking "up" step). We can take a guess at0(n log(n)) since there
are n nodes doing an average of log(n) amount of work on each step.
*/

public void findSum(TreeNode node, int sum, int[] path, int level){
	if(node == null)
		return;

	/* Insert current node into path. */
	path[level] = node.data;

	/* Look for paths with a sum that ends at this node. */
	int t = 0;
	for(int i = level; i >= 0; i--){
		t += path[i];
		if(t == sum){
			print(path, i, level)
		}
	}

	/* Search nodes beneath this one */
	findSum(node.left, sum, path, level + 1);
	findSum(node.right, sum, path, level + 1);

	/* Remove current node from path. Not strictly necessary, since
     * we would ignore this value, but it's good practice. */
	path[level] = Integer.MIN_VALUE;
}

public void findSum(TreeNode node, int sum){
	int depth = calDepth(node)
	int[] path = new int[depth];
	findSum(node, sum, path, 0);
}

public static void print(int[] path, int start, int end){
	for(int i = start, i <= end; i++){
		System.out.print(path[i] + " ");
	}
	System.out.println();
}

public int calDepth(TreeNode node){
	if(node == null)
		return 0;
	else
		return Math.max( calDepth(node.left), calDepth(node.right) ) + 1; 
}








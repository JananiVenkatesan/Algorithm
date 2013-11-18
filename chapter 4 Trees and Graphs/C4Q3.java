/*
Problem:
    Given a sorted (increasing order) array with unique integer 
elements, write an algorithm to create a binary search tree 
with minimal height.

Solution:

*/

public TreeNode createMinimalBST(int[] arr){
	createMinimalBST(arr, 0, arr.length - 1);
}

public TreeNode createMinimalBST(int[] arr, int start, int end){
	if(start > end)
		return null;
	int mid = start + (start - end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = createMinimalBST(arr, start, mid - 1);
	n.right = createMinimalBST(arr, mid + 1, end);
	return n;
}
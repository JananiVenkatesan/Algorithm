/*
Problem:
    Given a sorted (increasing order) array with unique integer 
elements, write an algorithm to create a binary search tree 
with minimal height.

Solution:

*/

public TreeNode createMinimalBST(int[] arr){
	if(arr == null || arr.length == 0)
		return null;
	createBST(arr, 0, arr.length - 1);
}

public TreeNode createBST(int[] arr, int start, int end){
	if(start > end)
		return null;
	int mid = start + (start - end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = createBST(arr, start, mid - 1);
	n.right = createBST(arr, mid + 1, end);
	return n;
}
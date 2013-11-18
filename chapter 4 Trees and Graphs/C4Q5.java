/*
Problem:

	Implement a function to check if a binary tree is a binary 
search tree.

Solution #1:
	We can implement this solution in two different ways. 

	The first leverages the in-order traversal,and the second builds off the
property that left <= current < right.



Solution #1: 

	In-Order Traversal

	Our first thought might be to do an in-order traversal, copy the elements 
to an array, and then check to see if the array is sorted. This solution takes 
up a bit of extra memory, but it works -- mostly.

	The only problem is that it can't handle duplicate values in the tree properly. 
For example, the algorithm cannot distinguish between the two trees below (one of 
which is invalid) since they have the same in-order traversal

      Valid BST     Invalid BST
         20			    20
	   /				   \ 
	20						20

	However, if we assume that the tree cannot have duplicate values,then this 
approach works. 
*/

static int prev = Integer.MAX_VALUE;

boolean isBST(TreeNode node){
	if(node == null)
		return true;

	if(!isBST(node.lChild))
		return false;
	if(prev >= node.data)
		return false;
	prev = node.data;
	if(!isBST(node.rChild))
		return false;

	return true
}

/*

Solution #2: The Min / Max Solution

	page 227

*/

public boolean isBST(TreeNode node){
	return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public boolean isBST(TreeNode node, int min, int max){
	if(node == null)
		return true;
	if(node.val < min || node.val > max)
		return false;
	if(!isBST(node.left, min, node.val) || !isBST(node.right, node.val, max))
		return false;
	return true;
}















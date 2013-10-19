/*
Problem:
	Implement a function to check if a binary tree is a binary search tree.

Solution #1:
	We can implement this solution in two different ways. 

	The first leverages the in-order traversal,and the second builds off the
property that left <= current < right.

Solution #1: In-Order Traversal
	Our first thought might be to do an in-order traversal, copy the elements 
to an array, and then check to see if the array is sorted. This solution takes 
up a bit of extra memory, but it works -- mostly.

	The only problem is that it can't handle duplicate values in the tree properly. 
For example, the algorithm cannot distinguish between the two trees below (one of 
which is invalid)sincethey havethe same in-order traversal

      Valid BST     Invalid BST
         20			    20
	   /				   \ 
	20						20

	However, if we assume that the tree cannot have duplicate values,then this 
approach works. 
*/

public static int last_print = Integer.MIN_VALUE;

public static boolean checkBST(TreeNode n){
	if(n == null)
		return true;

	if(!checkBST(n.lChild))
		return false;
	if(last_print >= n.data)  // compare previous node and current node
		return false;
	last_print = n.data;  // save the value of current node
	if(!checkBST(n.right))
		return false;

	return true;
}

/*
Solution #2: The Min / Max Solution
	page 227
*/

public boolean checkBST(TreeNode n, int min, int max){
	if(n == null)
		return true;
	if(n.data < min || n.data > max)
		return false;
	if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
		return false;
	return true;
}
















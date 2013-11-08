/*
Problem: 
	You have two very large binary trees: T1, with millions of nodes, 
and T2, with hundreds of nodes. Create an algorithm to decide if T2 is
a subtree of T1.
	A tree T2 is a subtree of Tl if there exists a node n in T1 such 
that the subtree of n is identical to T2. That is, if you cut off the 
tree at node n, the two trees would be identical.

Solution:
	page 235
*/

public boolean containsTree(TreeNode t1, TreeNode t2){
	if(t2 == null)  // the empty tree is always a subtree
		return true;
	return searchSubtree(t1, t2); 
}

public boolean searchSubtree(TreeNode t1, TreeNode t2){
	// big tree empty & subtree still not found
	if(t1 == null)
		return false;

	if(t1.data == t2.data)
		return matchTree(t1, t2);

	return searchSubtree(t1.left, t2) || searchSubtree(t1.right, t2);
}

public boolean matchTree(TreeNode t1, TreeNode t2){
	// if both are empty, nothing left in the subtree
	if(t1 == null && t2 == null)   
		return true;
	// if one, but not both, are empty
	if(t1 == null || t2 == null)
		return false;
	// data doesn't match
	if(t1.data != t2.data)
		return false
	return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
}






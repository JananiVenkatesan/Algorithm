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
	return subtree(t1, t2); 
}

public boolean subtree(TreeNode r1, TreeNode r2){
	if(r1 == null)
		return false;  // big tree empty & subtree still not found
	if(r1.data == r2.data){
		if(matchTree(r1, r2))
			return true;
	}
	return subtree(r1.left, r2) || subtree(r1.right, r2);
}

public boolean matchTree(TreeNode r1, TreeNode r2){
	if(r1 == null && r2 == null)   // if both are empty
		return true;
	// if one, but not both, are empty
	if(r1 == null || r2 == null)
		return false;
	// data doesn't match
	if(r1.data != r2.data)
		return false
	return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
}
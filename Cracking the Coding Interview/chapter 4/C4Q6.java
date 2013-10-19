/*
Problem:
	Write an algorithm to find the 'next'node (i.e., in-order successor) of 
a given node in a binary search tree. You may assume that each node has a 
link to its parent.

Solution:
	Recall that an in-order traversal traverses the left subtree, then the 
current node, then the right subtree. To approach this problem, we need to 
think very, very carefully about what happens.
*/

public TreeNode inorderSuccessor(TreeNode n){
	if(n == null)
		return null;
	/* Found right children -> return leftmost node of right subtree. */
	if(n.right != null){
		return mostLeftChild(n.right);
	}else{
		TreeNode q = n;
		TreeNode p = q.parent;
		// Go up until we're on left instead of right
		while(p != null && p.left != q){
			q = p;
			p = p.parent;
		}
	}
	return x;
}

public TreeNode mostLeftChild(TreeNode n){
	if(n == null){
		return null;
	}
	while(n.left != null){
		n = n.left;
	}
	return n;
}
/*
Problem:

	Write an algorithm to find the 'next' node (i.e., in-order successor) of 
a given node in a binary search tree. You may assume that each node has a 
link to its parent.



Solution:

	Recall that an in-order traversal traverses the left subtree, then the 
current node, then the right subtree. To approach this problem, we need to 
think very, very carefully about what happens.

*/



public TreeNode inorderSuccessor(TreeNode node){
	if(node == null)
		return null;
	/* Found right children -> return leftmost node of right subtree. */
	if(node.rChild != null){
		return findMostLeft(node.rChild);
	}else{
		TreeNode q = node;
		TreeNode p = node.parent;
		// Go up until we're on left instead of right
		while(p != null && p.rChild == q){
			q = p;
			p = p.parent;
		}
		return p;
	}
}

TreeNode findMostLeft(TreeNode node){
	if(node == null)
		return null;

	while(node.lChild != null){
		node = node.lChild;
	}
	return node;
}


/*

Follow up

	case of preorder

*/


public TreeNode preOrderNext(TreeNode node){
	if(node == null){
		return null;
	}

	if(node.lChild != null){
		return node.lChild;
	}else if(node.rChild != null){
		return node.rChild;
	}else{
		return findParentWithRChild();
	}
}

public TreeNode findParentWithRChild(){	
	TreeNode q = node;
	TreeNode p = q.parent;
	while(p != null && (p.rChild == null || p.rChild == q ){
		q = p;
		p = p.parent;
	}
	if(p.rChild.rChild == null)
		return node;
	return p.rChild;
}
/*
case 1
		 /
		/
		\
		 \
		  \
		  /
		 /
		/


case 2
	\
	 \
	  \
	   \
	   /
	  /
	 /
*/




/*
Problem:
	Write an algorithm to find the 'next' node (i.e., in-order 
successor) of a given node in a binary search tree. You may 
assume that each node has a link to its parent.

Solution:
	Recall that an in-order traversal traverses the left subtree, 
then the current node, then the right subtree. To approach this 
problem, we need to think very, very carefully about what happens.

*/

public Node inorderSuccessor(Node node){
	if(node == null)
		return null;
	if(node.right != null)
		return getMostLeft(node.right);
	return getParentNode(node);
}

private Node getMostLeft(Node node){
	if(node == null)
		return null;
	while(node.left != null){
		node = node.left;
	}
	return node;
}

private Node getParentNode(Node node){
	Node p = node.parent;
	while(p != null && p.left != node){
		node = p;
		p = p.parent;
	}
	return p;
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
		return findParentWithRChild(node);
	}
}

public TreeNode findParentWithRChild(TreeNode node){	
	TreeNode p = node.parent;
	while(p != null && (p.rChild == null || p.rChild == q)){
		node = p;
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




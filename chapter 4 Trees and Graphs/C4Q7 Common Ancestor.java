/*
Problem:
	Design an algorithm and write code to find the first common 
ancestor of two nodes in a binary tree. Avoid storing additional 
nodes in a data structure.  

	NOTE: This is not necessarily a binary search tree.
*/

public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
	if(root == null)
		return null;
	if(root == p || root == q)
		return root;
	TreeNode left = findLCA(root.left, p, q);
	TreeNode rigth = findLCA(root.right, p, q);
	if(left != null && right != null){
		return root;
	}else{
		return left != null ? left : right;
	}
}




/*
Solution 1:
	page 231
	loop tranverse
*/

public Node commonAncestor(Node root, Node p, Node q) {
	if (!covers(root, p) || !covers(root, q)) { // Error check 
		return null;
	}
	return commonAncestorHelper(root, p, q);
}

public boolean covers(Node root, Node node){
	if(root == null)
		return false;
	if(root == node)
		return true;
	return covers(root.left, node) || covers(root.right, node);
}

public Node commonAncestorHelper(Node node, Node p, Node q){
	if(node == null)
		return null;
	if(node == p || node == q)  // node is p or q
		return node;
	boolean is_p_on_left = covers(node.left, p);
	boolean is_q_on_left = covers(node.left, q);
	/* If p and q are on different sides, return node. */
	if(is_p_on_left != is_q_on_left)
		return node;
	/* Else, they are on the same side. Traverse this side. */
	Node child = is_p_on_left ? node.left : node.right;
	return commonAncestorHelper(child, p, q)
}


/*

Solution 2:
	page 232
*/

public static class Result{
	public Node node;
	public boolean isAncestor;
	
	public Result(Node n, boolean isAnc){
		node = n;
		isAncestor = isAnc;
	}
}

public Result commonAncestorHelper(Node root, Node p, Node q){
	if(root == null)
		return new Result(null, false);
	if(root == p && root == q)
		return new Result(root, true);

	Result rLeft = commonAncestorHelper(root.left, p, q);
	if(rLeft.isAncestor)  // found common ancestor already, return that common ancestor
		return rLeft;
	Result rRight = commonAncestorHelper(root.right, p, q);
	if(rRight.isAncestor)
		return rRight;    // found common ancestor already, return that common ancestor
	if(rLeft.node != null && rRight.node != null){
		/*
		    both of its subtrees contains one node, but neither of them is common ancestor,
		    then root is the common ancestor
		*/
		return new Result(root, true);
	}else if(root == p || root == q){  
	    /* 
	        if root is one node, and either of its subtree contains another node,
	        then root is the common anscestor
			if root is one node, and neither of its subtree contains another node,
			return new Result(root, false)
		*/
		boolean isAncestor = rLeft.node != null || rRight.node != null ? true : false;
		return new Result(root, isAncestor);
	}else{
		/*
			keeps returning new Result(null, false) until one node is found
		*/
		return new Result(rLeft != null ? rLeft : rRight, false);
		/*
		if(rLeft != null)
			return new Result(rLeft, false);
		else
			return new Result(rRight, false);
		*/
	}
}

public Node commonAncestor(Node root, Node p, Node Q){
	Result r = commonAncestorHelper(root, p, q);
	if(r.isAncestor)
		return r.node;
	return null;
}








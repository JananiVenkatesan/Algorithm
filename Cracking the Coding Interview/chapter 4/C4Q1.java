/*
Problem:
    Implement a function to check if a binary tree is balanced. For 
the purposes of this question, a balanced tree is defined to be a 
tree such that the heights of the two subtrees of any node never 
differ by more than one.

Solution 1:
    Simply recurse through the entire tree, and for each node, compute 
the heights of each subtree. 
    
    But since getHeight() is called repeatedly on the same nodes.The 
algorithm is therefore O(N2)
*/

public static int getHeight(TreeNode root){
	if(rootNode == null)
		return 0;
	return Math.max(getHeight(root.lChild), getHeight(root.rChild)) + 1;
}

public static boolean isBalance(TreeNode root){
	if(root == null)
		return ture;

	int heightDiff = getHeight(root.lChild) - getHeight(root.rChild);
	if(Math.abs(heightDiff) > 1){
		return false;
	}else{  // recurse
		return isBalance(root.lChild) && isBalance(root.rChild);
	}
}

/*
Solution 2:
    If we inspect this method, we may notice that getHeight could 
actually check if the tree is balanced as the same time as it's 
checking heights. What do we do when we discover that the subtree 
isn't balanced? Just return -1.

    This improved algorithm works by checking the height of each 
subtree as we recurse down from the root. On each node, we recursively 
get the heights of the left and right subtrees through the checkHeight 
method. If the subtree is balanced, then check- Height will return the 
actual height of the subtree. If the subtree is not balanced, then 
checkHeight will return -1. Wewill immediately break and return -1 from 
the current call.
*/

public static int checkHeight(TreeNode root){
	if(root == null)
		return 0;
	int lHeight = checkHeight
	if(checkHeightroot.lChild == -1 || checkHeight(root.rChild) == -1)

}















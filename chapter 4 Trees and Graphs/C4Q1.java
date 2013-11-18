/*
Problem:
   
    Implement a function to check if a binary tree is balanced. For 
the purposes of this question, a balanced tree is defined to be a 
tree such that the heights of the two subtrees of any node never 
differ by more than one.



Solution 1:

    Simply recurse through the entire tree, and for each node, compute 
the heights of each subtree. 
    
    But since getHeight() is called repeatedly on the same nodes. The 
algorithm is therefore O(N^2)

*/

int getHeight(TreeNode root){
	if(rootNode == null)
		return 0;
	return Math.max(getHeight(root.lChild), getHeight(root.rChild)) + 1;
}

boolean isBalance(TreeNode root){
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

    If we inspect this method, we may notice that getHeight() could 
actually check if the tree is balanced as the same time as it's 
checking heights. What do we do when we discover that the subtree 
isn't balanced? Just return -1.

    This improved algorithm works by checking the height of each 
subtree as we recurse down from the root. On each node, we recursively 
get the heights of the left and right subtrees through the checkHeight 
method. If the subtree is balanced, then checkHeight will return the 
actual height of the subtree. If the subtree is not balanced, then 
checkHeight will return -1. We will immediately break and return -1 from 
the current call.

*/

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return true;
        if(checkHeight(root) == -1)
            return false;
        else
            return true;
    }
    
    public int checkHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int lHeight = checkHeight(node.left);
        int rHeight = checkHeight(node.right);
        if(lHeight == -1 || rHeight == -1){
            return -1;
        }
        return Math.abs(lHeight - rHeight) > 1 ? -1 : Math.max(lHeight, rHeight) + 1;
    }
}













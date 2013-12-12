/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return true;
        if(checkBalance(root) != -1)
            return true;
        else
            return false;
    }
    public int checkBalance(TreeNode node){
        if(node == null)
            return 0;
        int lHeight = checkBalance(node.left);
        int rHeight = checkBalance(node.right);
        if(lHeight == -1 || rHeight == -1)
            return -1;
        if(Math.abs(lHeight - rHeight) > 1)
            return -1;
        return Math.max(lHeight, rHeight) + 1;
    }
}
/*

Problem:

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest 
path from the root node down to the nearest leaf node.


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return 0;
        return findMin(root);
    }
    public int findMin(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return Math.min(findMin(node.left), findMin(node.right)) + 1;
    }
}
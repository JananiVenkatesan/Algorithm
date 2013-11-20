/*

    Given a binary tree, check whether it is a mirror of itself 
    (ie, symmetric around its center).

    For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3

*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        
        return isSymm(root.left, root.right);
    }
    public boolean isSymm(TreeNode l, TreeNode r){
        if(l == null && r == null)
            return true;
        if(l == null || r == null)
            return false;
        if(l.val != r.val)
            return false;
        else
            return isSymm(l.left, r.right) && isSymm(l.right, r.left);
    }
}
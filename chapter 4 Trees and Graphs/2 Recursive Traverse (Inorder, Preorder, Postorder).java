/*

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(root == null)    
            return l;
        preorder(root, l);
        return l;
    }
    public void preorder(TreeNode node, ArrayList<Integer> l){
        if(node != null){
            l.add(node.val);
            preorder(node.left, l);
            preorder(node.right, l);
        }
    }
}

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(root == null)
            return l;
        inorder(root, l);
        return l;
    }
    public void inorder(TreeNode node, ArrayList<Integer> l){
        if(node != null){
            inorder(node.left, l);
            l.add(node.val);
            inorder(node.right, l);
        }
    }
}

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(root == null)
            return l;
        postorder(root, l);
        return l;
    }
    public void postorder(TreeNode node, ArrayList<Integer> l){
        if(node != null){
            postorder(node.left, l);
            postorder(node.right, l);
            l.add(node.val);
        }
    }
}
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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        preorder(root, stack);
        root.right = null;  // IMPORTANT!
        root.left = null;   // MORE IMPORTANT! To isolate root
        while(stack.size() > 1){
            TreeNode node = new TreeNode(stack.pop());
            node.right = root.right;
            root.right = node;
        }
        
    }
    public void preorder(TreeNode node, Stack<Integer> stack){
        if(node == null)
            return;
        stack.push(node.val);
        preorder(node.left, stack);
        preorder(node.right, stack);
    }
}
/*
Given a binary tree, return the bottom-up level order traversal 
of its nodes' values. (ie, from left to right, level by level 
from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        if(root == null){
            return lists;
        }
        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        l.add(root);
        value.add(root.val);
        stack.add(value);
        
        ArrayList<TreeNode> current = null;
        while(!l.isEmpty()){
            current = new ArrayList<TreeNode>();
            value = new ArrayList<Integer>();
            for(TreeNode node : l){
                if(node.left != null){
                    current.add(node.left);
                    value.add(node.left.val);
                }
                if(node.right != null){
                    current.add(node.right);
                    value.add(node.right.val);
                }
            }
            if(!value.isEmpty())
                stack.add(value);
            l = current;
        }
        while(!stack.isEmpty())
            lists.add(stack.pop());
        return lists;
    }
}
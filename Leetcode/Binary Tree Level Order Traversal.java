/*
Given a binary tree, return the level order traversal of its nodes' 
values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // Define lists at first, or we cannot handle the null case
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return lists;
        }
        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        l.add(root);
        value.add(root.val);
        lists.add(value);
        
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
            // Caution! If value list is empty, do not add it to lists
            if(!value.isEmpty())
                lists.add(value);
            l = current;
        }
        return lists;
    }
}
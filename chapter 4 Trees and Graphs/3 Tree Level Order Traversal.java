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


 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return lists;
        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        l.add(root);
        value.add(root.val);
        lists.add(value);
        while(l.size() != 0){
            ArrayList<TreeNode> prev = l;
            l = new ArrayList<TreeNode>();
            value = new ArrayList<Integer>();
            for(TreeNode node: prev){
                if(node.left != null){
                    l.add(node.left);
                    value.add(node.left.val);
                }
                if(node.right != null){
                    l.add(node.right);
                    value.add(node.right.val);
                }
            }
            // Caution! If value list is empty, do not add it to lists
            if(value.size() != 0)
                lists.add(value);
        }
        return lists;
    }
}
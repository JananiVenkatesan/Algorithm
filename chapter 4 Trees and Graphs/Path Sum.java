/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Path Sum
/* 
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        // A leaf
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}


Path Sum II 
/*
    Given a binary tree and a sum, find all root-to-leaf paths where 
each path's sum equals the given sum.

For example:
    Given the below binary tree and sum = 22,
            
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return lists;
        ArrayList<Integer> l = new ArrayList<Integer>();
        findPath(lists, l, sum, root);
        return lists;
        
    }
    public void findPath(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> l, int sumSalvage, TreeNode node){
        if(node == null)
            return;
        l.add(node.val);
        if(node.val == sumSalvage && node.left == null && node.right == null){
            ArrayList<Integer> l_copy = new ArrayList<Integer>(l);
            lists.add(l_copy);
        }
        findPath(lists, l, sumSalvage - node.val, node.left);
        findPath(lists, l, sumSalvage - node.val, node.right);
        l.remove(l.size() - 1);
    }
}


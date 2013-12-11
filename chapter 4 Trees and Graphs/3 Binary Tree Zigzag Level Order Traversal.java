/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        boolean isOdd = true;
        while(!stack.isEmpty()){
            Stack<TreeNode> temp = new Stack<TreeNode>();
            ArrayList<Integer> l = new ArrayList<Integer>();
            while(!stack.isEmpty()){
                TreeNode t = stack.pop();
                l.add(t.val);
                if(isOdd){
                    if(t.left != null)
                        temp.push(t.left);
                    if(t.right != null)
                        temp.push(t.right);
                }
                else{
                    if(t.right != null)
                        temp.push(t.right);
                    if(t.left != null)
                        temp.push(t.left);
                }
            }
            lists.add(l);
            stack = temp;
            isOdd = !isOdd;
        }
        return lists;
    }
}
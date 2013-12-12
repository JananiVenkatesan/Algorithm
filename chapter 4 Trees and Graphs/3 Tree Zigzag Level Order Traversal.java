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
        ArrayList<Integer> value = new ArrayList<Integer>();
        
        stack.push(root);
        value.add(root.val);
        lists.add(value);
        
        boolean isOdd = true;
        while(!stack.isEmpty()){
            Stack<TreeNode> prev = stack;
            stack = new Stack<TreeNode>();
            value = new ArrayList<Integer>();
            while(!prev.isEmpty()){
                TreeNode node = prev.pop();
                if(isOdd){
                    if(node.right != null){
                        stack.push(node.right);
                        value.add(node.right.val);
                    }
                    if(node.left != null){
                        stack.push(node.left);
                        value.add(node.left.val);
                    }
                }
                else{
                    if(node.left != null){
                        stack.push(node.left);
                        value.add(node.left.val);
                    }
                    if(node.right != null){
                        stack.push(node.right);
                        value.add(node.right.val);
                    }
                }
            }
            if(value.size() != 0){
                lists.add(value);
            }
            isOdd = !isOdd;
        }
        return lists;
    }
}
/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf 
path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.
    For example,

        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
*/
    
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbers(root, 0, 0);
    }
    
    public int sumNumbers(TreeNode root, int sum, int pathSum){
        if(root.left == null && root.right == null){
            return sum + pathSum * 10 + root.val;
        }
        if(root.left != null)
            sum = sumNumbers(root.left, sum, pathSum * 10 + root.val);
        if(root.right != null)
            sum = sumNumbers(root.right, sum, pathSum * 10 + root.val);
        return sum;
    }
}


public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbers(root, root.val, 0);
    }
    
    public int sumNumbers(TreeNode node, int pathSum, int sum){
        if(node.left == null && node.right == null){
            sum += pathSum;
            return sum;
        }
        if(node.left != null)
            sum = sumNumbers(node.left, pathSum * 10 + node.left.val, sum);
        if(node.right != null)
            sum = sumNumbers(node.right, pathSum * 10 + node.right.val, sum);
        return sum;
    }
}




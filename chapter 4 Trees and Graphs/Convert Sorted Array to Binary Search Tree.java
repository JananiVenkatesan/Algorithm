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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num == null)
            return null;
        return createBST(num, 0, num.length - 1);
    }
    public TreeNode createBST(int[] num, int low, int high){
        if(low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = createBST(num, low, mid - 1);
        node.right = createBST(num, mid + 1, high);
        return node;
    }
}
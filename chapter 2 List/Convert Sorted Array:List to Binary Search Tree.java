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
    
    public TreeNode createBST(int[] num, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode t = new TreeNode(num[mid]);
        t.left = createBST(num, start, mid - 1);
        t.right = createBST(num, mid + 1, end);
        return t;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return null;
        int length = 1;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
            length ++;
        }
        return toBST(head, 0, length - 1);
    }
    public TreeNode toBST(ListNode node, int start, int end){
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        ListNode n = node;
        for(int i = start; i < mid; i ++){
            n = n.next;
        }
        
        TreeNode midNode = new TreeNode(n.val);
        midNode.left = toBST(node, start, mid - 1);
        midNode.right = toBST(n.next, mid + 1, end);
        return midNode;
    }
}
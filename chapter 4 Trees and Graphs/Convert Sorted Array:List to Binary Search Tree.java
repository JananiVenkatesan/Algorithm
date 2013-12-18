
// Convert Sorted Array to Binary Search Tree
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0)
            return null;
        return createBST(num, 0, num.length - 1);
    }
    
    private TreeNode createBST(int[] num, int left, int right){
        if(left > right)  // IMPORTANT!!!
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = createBST(num, left, mid - 1);
        root.right = createBST(num, mid + 1, right);
        return root;
    }
}


// Convert Sorted List to Binary Search Tree
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        
        int length = 1;
        ListNode n = head;
        while(n.next != null){
            n = n.next;
            length ++;
        }
        
        return createBST(head, 0, length - 1);
    }
    
    private TreeNode createBST(ListNode node, int left, int right){
        if(left > right)
            return null;
        int mid = left + (right - left) / 2;
        ListNode n = node;
        for(int i = left; i < mid; i ++){  // IMPORTANT!!! start from LEFT!!!
            n = n.next;
        }
        
        TreeNode root = new TreeNode(n.val);
        root.left = createBST(node, left, mid - 1);
        root.right = createBST(n.next, mid + 1, right);
        return root;
    }
}
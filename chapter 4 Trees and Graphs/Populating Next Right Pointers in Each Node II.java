/*

    Follow up for problem "Populating Next Right Pointers in Each Node".

    What if the given tree could be any binary tree? Would your previous solution still work?

    Note:

    You may only use constant extra space.
    For example,
    Given the following binary tree,
    
         1
       /  \
      2    3
     / \    \
    4   5    7
    
    After calling your function, the tree should look like:
   
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL



 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return;
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.add(root);
        
        
        while(!list.isEmpty()){
            TreeLinkNode p = null;
            for(TreeLinkNode node : list){
                if(p == null){
                    p = node;
                }else{
                    p.next = node;
                    p = node;
                }
            }
            p.next = null;
        
            LinkedList<TreeLinkNode> prev = list;
            list = new LinkedList<TreeLinkNode>();
            for(TreeLinkNode node : prev){
                if(node.left != null){
                    list.add(node.left);
                }
                if(node.right != null){
                    list.add(node.right);
                }
            }
        }
    }
}
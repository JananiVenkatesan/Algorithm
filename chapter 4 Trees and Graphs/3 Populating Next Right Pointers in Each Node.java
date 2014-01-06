/*
Given a binary tree
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.

Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are 
at the same level, and every parent has two children).
    For example,
    Given the following perfect binary tree,
         1
        / \
       2   3
      / \ / \
     4  5 6  7
    
    After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        root.next = null;
        list.add(root);
        
        while(list.size() != 0){
            LinkedList<TreeLinkNode> prev = list;
            list = new LinkedList<TreeLinkNode>();
            
            for(TreeLinkNode n : prev){
                if(n.left != null)
                    list.add(n.left);
                if(n.right != null)
                    list.add(n.right);
            }
        
            if(list.size() != 0){
                TreeLinkNode p = null;
                for(TreeLinkNode n : list){
                    if(p == null){
                        p = n;
                    }
                    else{
                        p.next = n;
                        p = n;
                    }
                }
                p.next = null;
            }
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.add(root);
        
        while(!list.isEmpty()){
            TreeLinkNode p = null;
            for(TreeLinkNode node: list){
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

            for(TreeLinkNode node: prev){
                if(node.left != null){
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }
    }
}
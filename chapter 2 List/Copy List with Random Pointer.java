/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        
        // Create new copy node and insert it between original ones
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        
        // Copy random pointers
        cur = head;
        while(cur != null){
            if(cur.random == null)  // If node.random == null
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;  // Else node.next.random == node.random.next
                
            cur = cur.next.next;
        }
        
        RandomListNode newhead = head.next;
        cur = head;
        RandomListNode newcur = newhead;
        
        while(cur.next.next != null){   // Break the list into two seperate lists
            cur.next = cur.next.next;
            newcur.next = newcur.next.next;
            cur = cur.next;
            newcur = newcur.next;
        }
        
        // Deal with the last pointer
        cur.next = null;
        newcur.next = null;
        
        return newhead;
    }
}
/*
Sort a linked list using insertion sort.
*/

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        
        ListNode cur = head.next;
        head.next = null;
        
        while(cur != null){
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            
            ListNode current = newhead.next, prev = newhead;
            while(current != null && temp.val > current.val){  // IMPORTANT!  current != null 要放在前面！否则会有空指针异常
                current = current.next;
                prev = prev.next;
            }
            
            if(current == null){
                prev.next = temp;
            }
            else{
                temp.next = current;
                prev.next = temp;
            }
        }
        return newhead.next;
    }
}
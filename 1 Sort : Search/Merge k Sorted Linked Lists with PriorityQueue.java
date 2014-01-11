/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
            
        for(int i = lists.size() - 1; i >= 0; i --){
            if(lists.get(i) == null)
                lists.remove(i);
        }
        if(lists.size() == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
               return n1.val - n2.val;
            }
        });
      
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }
      
        ListNode newhead = new ListNode(0);
        ListNode cur = newhead;
        
        while(pq.size() != 0){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null)
                pq.add(cur.next);
        }
        return newhead.next;
    }
}
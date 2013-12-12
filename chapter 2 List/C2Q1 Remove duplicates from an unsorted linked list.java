/*
Problem:
	Write code to remove duplicates from an unsorted linked list. 
	
Solution:
	In order to remove duplicates from a linked list, we need to be able 
to track duplicates. A simple hash table will work well here.
*/

// use buffer - Time Efficiency -> O(N)
class Solution{
    public void removeDuplicate(ListNode n){
        if(n == null)
            return;
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        ListNode prev = null;
        while(n != null){
            if(!hm.containsKey(n.val)){
                prev = n;
                hm.put(n.val, true);
            }
            else{
                prev.next = n.next;
            }
            n = n.next;
        }
    }
}

/*
FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
*/

// no buffer used - Time Efficiency -> O(N^2)
public void removeDuplicate(ListNode n){
	if(n == null)
		return;
	
	ListNode current = n;
	while(current != null){
		ListNode cur = current;
		while(cur != null){
			if(cur.next.val == current.val){
				cur.next = cur.next.next;
			}
			else{
				cur = cur.next;
			}
		}
		current = current.next;
	}
}







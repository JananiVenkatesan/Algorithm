    JDK的 PriorityQueue, 它是使用最大堆来实现的
    
    如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小
    的在队列头，字符串则按字典序排列

	peek()
		Retrieves, but does not remove, <the head of this queue>, or 
		returns null if this queue is empty.
 	poll()
    	Retrieves and removes <the head of this queue>, or returns null 
    	if this queue is empty.

------------

public class Leetcode{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
        int[] n = {9,5,3,8,7,4,10,12,32,1,2};

        for(int i = 0; i < n.length; i ++){
        	if(pq.size() < 3){
        		pq.add(n[i]);
        	}else{
        		if(pq.peek() < n[i]){  // 最小值在堆顶，最小值在PriorityQueue的队头
        			pq.remove();
        			pq.add(n[i]);
        		}
        	}
        }
        
        for(Integer i : pq){
        	System.out.println(i);
        }
        // 10, 12, 32
    }
}

------------

    PriorityQueue is an unbounded queue based on a priority heap and the
elements of the priority queue are ordered by default in natural order or
we can provide a Comparator for ordering at the time of instantiation 
of queue.

    PriorityQueue doesn’t allow null values and we can’t create 
PriorityQueue of Objects that are non-comparable, for example any custom
classes we have. !!!We use java Comparable and Comparator interfaces for
sorting Objects and PriorityQueue use them for priority processing of 
it’s elements.!!!

    The head of the priority queue is the least element based on the 
natural ordering or comparator based ordering, if there are multiple objects with same ordering, then it can poll any one of them randomly. 
When we poll the queue, it returns the head object from the queue.

    PriorityQueue size is unbounded but we can specify the initial 
capacity at the time of it’s creation. When we add elements to the 
priority queue, it’s capacity grows automatically.

    PriorityQueue implementation provides !!!O(log(n))!!! time for enqueing 
and dequeing method. Let’s see an example of PriorityQueue for natural
ordering as well as with Comparator.


	http://blog.csdn.net/xiao__gui/article/details/8687982

--------------

public class Customer{
	public int id;
}

--------------
import java.util.*;

public class Leetcode{
    public static void main(String[] args){
        PriorityQueue<Customer> pq = 
            new PriorityQueue<Customer>(3, new Comparator<Customer>(){
				public int compare(Customer c1, Customer c2){
					return c2.id - c1.id;
				}	
	        });

	    /*
		PriorityQueue<Customer> pq = 
            new PriorityQueue<Customer>(3, new Comparator<Customer>(){
				public int compare(Customer c1, Customer c2){
					return c1.id - c2.id;
				}	
	        });
	    */

        Customer[] c = new Customer[6]; 
        for(int i = 0; i < 6; i ++){
        	c[i] = new Customer();
        }

        c[0].id = 1;
        c[1].id = 10;
        c[2].id = 13;
        c[3].id = 4;
        c[4].id = 9;
        c[5].id = 2;

        for(int i = 0; i < c.length; i ++){
        	if(pq.size() < 3){
        		pq.add(c[i]);
        	}else{
        		if(pq.peek().id > c[i].id){  // 最大值在堆顶，最大值在PriorityQueue的队头
        			pq.remove();
        			pq.add(c[i]);
        		}
        	}
        }
        /*
		for(int i = 0; i < c.length; i ++){
        	if(pq.size() < 3){
        		pq.add(c[i]);
        	}else{
        		if(pq.peek().id < c[i].id){  // 最小值在堆顶，最小值在PriorityQueue的队头
        			pq.remove();
        			pq.add(c[i]);
        		}
        	}
        }
        */
        for(Customer cus : pq){
        	System.out.println(cus.id); 
        }
        // 4 1 2
        // 9 13 10
    }
}


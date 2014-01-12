import java.util.concurrent.*;

interface Cache<K, V>{ 
	V get(K key); 
	void put(K key, V value); 
	void clear(); 
} 

class LRUCache<K, V> implements Cache<K, V>{
	private final int capacity;
	private ConcurrentLinkedQueue<K> queue;
	private ConcurrentHashMap<K, V> map;

	public LRUCache(int c){
		capacity = c;
		queue = new ConcurrentLinkedQueue<K>();
		map = new ConcurrentHashMap<K, V>(capacity);
	}

	public V get(K key){
		return map.get(key);
	}

	public synchronized void put(K key, V value){
		if(key == null || value == null){
			throw new NullPointerException();
		}
		if(map.containsKey(key)){
			queue.remove(key);
		}
		while(queue.size() >= capacity){
			K expiredKey = queue.poll();
			if(expiredKey != null){
				map.remove(expiredKey);
			}
		}
		/*
		if(queue.size() >= capacity){
			K expiredKey = queue.poll();
			if(expiredKey != null){
				map.remove(expiredKey);
			}
		}
		*/

		queue.add(key);
		map.put(key, value);
		printMapQueue();
	}
	public void clear(){
		map.clear();
		queue = new ConcurrentLinkedQueue<K>();
	}
	public void printMapQueue(){
		System.out.println(queue);
		System.out.println(map);
		System.out.println();
	}

}

public class CacheTest{
	public static void main(String[] args){
		LRUCache<Integer, String> c = new LRUCache<Integer, String>(4);
		c.put(1, "a");
		c.put(2, "b");
		c.put(3, "c");
		c.put(4, "d");
		c.put(5, "e");
		c.clear();
		c.put(6, "f");
		c.put(4, "d");
		c.put(2, "b");
	}
}

------------------------

public class LRUCache {
    private final int capacity;
    private ArrayList<Integer> queue;
    private HashMap<Integer, Integer> map;
    
    public LRUCache(int c) {
        capacity = c;
        queue = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
            return map.get(key);
        else 
            return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            queue.remove((Integer)key);
        }
        
        if(queue.size() >= capacity){
            Integer expiredKey = queue.remove(0);
            if(expiredKey != null){
                map.remove(expiredKey);
            }
        }
        queue.add(key);
        map.put(key, value);
        return;
    }
}

------------------------
/*
	超时的原因是因为我用remove方法在删除链表中一个指定元素的时候，
这个时候程序会遍历真个链表直到找到该元素。显然，如果容量为N，那么最
坏情况是会需要O(N)时间。

	这个问题也是这题的难点所在，在将某一个指定元素移到表头时，只允
许用常数时间。要做到这点，就必须的自己动手构造双向链表了。因为如果使
用现成的LinkedList，每次的实际操作起始地点都必须是链表表头。如果自
己构造链表元素，可以手动插入prev和next指针，然后提取出指定元素并插
入到表头。

另外网上有人指出可以直接扩展Java的LinkedHashMap这个类库，代码可以非常精简
*/

public class LRUCache {
    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int c) {
        capacity = c;
        map = new HashMap<Integer, Node>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    private class Node{
        public Node prev, next;
        public int key;
        public int value;
        
        public Node(int k, int v){
            key = k;
            value = v;
        }
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        attach(cur);
        return cur.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.value = value;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            attach(cur);
        }
        else{
            if(map.size() == capacity){
                dettach();
            }
            Node cur = new Node(key, value);
            attach(cur);
            map.put(key, cur);
        }
    }
    
    private void attach(Node cur){
        cur.prev = tail.prev;
        tail.prev.next = cur;
        tail.prev = cur;
        cur.next = tail;
    }
    
    private void dettach(){
        Node first = head.next;
        first.next.prev = head;
        head.next = first.next;
        map.remove(first.key);
    }
}
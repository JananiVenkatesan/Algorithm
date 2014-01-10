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
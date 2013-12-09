import java.util.*;

class MyArray<T> implements Iterable<T>{
	T[] elems;
	int length = 0;

	public MyArray(T[] data){
		elems = data;
		length = data.length;
	}

	public Iterator<T> iterator(){
		return new MyIterator<T>();
	}

	private class MyIterator<T> implements Iterator<T>{
		int next = 0;

		public boolean hasNext(){
			return next < length;
		}

		public T next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			T t = (T)elems[next];
			next ++;
			return t;
		}

		public void remove(){}
	}
}

public class Test  {
  public static void main(String[] args) {
        Integer[] i = new Integer[10];
		for(int j = 0; j < i.length; j ++)
			i[j] = 10 - j;

		try{
			MyArray<Integer> mi = new MyArray<Integer>(i);
			
			// Check 1
			for(Integer it : mi){
				System.out.println(it);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class MyIterable<T> implements Iterable<T>{
	T[] elems;
	int nElems;

	public MyIterator(T[] data){
		elems = data;
		nElems = data.length;
	}

	public Iterator<T> iterator(){
		return new MyIterator<T>();
	}

	private class MyIterator<T> implements Iterator<T>{
		int nextElem = 0;
		boolean hasRemoved = true;

		public boolean hasNext(){
			return nextElem > nElems;
		}

		public T next(){
			if(!hasNext()){
				throw new NoSuchElementException("No more elements");
			}

			T t = elems[nextElem];
			nextElem ++;
			hasRemoved = false;
			return e;
		}

		public void remove(){
			if(hasRemoved){
				throw new IllegalStateException(  
           			"The remove method can only be called once and after the next method.");  
			}

			if(nextElem < nElems - 1){
				System.arraycopy(elems, nextElem + 1, elems, nextElem, nElems - next - 1);
			}
			nElems --;
			hasRemoved = true;
		}
	}
}
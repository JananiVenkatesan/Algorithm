import java.util.*;

public class TopOneThousandWords{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter file name");
		String filename = scanner.nextLine();
		// Read file
		SimpleInput input = new SimpleInput(filename);
    	input.setDelimiters(" \t,:;.?-[]{}!");
    	// Loop into hashmap
    	HashMap<String, WordCount> hm = new HashMap<String, WordCount>();
    	String s = null;
    	while((s = input.nextWord()) != null){
    		// transform word to lower cases
    		s = s.toLowerCase();
    		if(hm.containsKey(s)){
    			((WordCount)hm.get(s)).count ++;
    		}
    		else{
    			hm.put(s, new WordCount(s));
    		}
    	}

    	// Loop into PriorityQueue
    	PriorityQueue<WordCount> pq = new PriorityQueue<WordCount>(1000, new Comparator<WordCount>(){
    		@Override
    		public int compare(WordCount c1, WordCount c2){
    			return c1.count - c2.count;
    		}
    	});
    	Collection<WordCount> collection = hm.values();
    	for(WordCount w : collection){
    		if(pq.size() < 1000){
    			pq.add(w);
    		}
    		else{
    			if(pq.peek().count < w.count){
    				pq.remove();
    				pq.add(w);
    			}
    		}
    	}
    	System.out.println(pq.toString());
	}
}

class WordCount{
	public String word;
	public int count;
	public WordCount(String w){
		word = w;
		count = 1;
	}
	public String toString(){
		return word + "=" + count;
	}
}
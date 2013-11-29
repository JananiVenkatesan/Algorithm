import java.util.*;
import java.io.*;

public class TopLetters{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("1000words.txt"));
		HashMap<Character, LetterCount> hm = new HashMap<Character, LetterCount>();
		String word = null;
		while((word = br.readLine()) != null){
			for(int i = 0; i < word.length(); i ++){
				char c = word.charAt(i);
				if(hm.containsKey(c)){
					((LetterCount)hm.get(c)).count ++;
				}
				else{
					hm.put(c, new LetterCount(c));
				}
			}
		}
		PriorityQueue<LetterCount> pq = new PriorityQueue<LetterCount>(10, new Comparator<LetterCount>(){
			@Override
			public int compare(LetterCount l1, LetterCount l2){
				return l1.count - l2.count;
			}
		});
		Collection<LetterCount> collection = hm.values();
		for(LetterCount lc : collection){
			if(pq.size() < 10){
				pq.add(lc);
			}
			else{
				if(pq.peek().count < lc.count){
					pq.remove();
					pq.add(lc);
				}
			}
		}
		
		for(LetterCount lc : pq){
			System.out.println(lc);
		}
	}
}

class LetterCount{
	public char ch;
	public int count;
	public LetterCount(char c){
		ch = c;
		count = 1;
	}
	public String toString(){
		return ch + "=" + count;
	}	
}

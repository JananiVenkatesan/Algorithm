import java.util.*;
import java.io.*;

public class TopLettersWithArrayList{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("1000words.txt"));
		HashMap<Character, LetterCount> hm = new HashMap<Character, LetterCount>();
		String word = null;
		while((word = br.readLine()) != null){
			word = word.toUpperCase();
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
		ArrayList<LetterCount> list = new ArrayList<LetterCount>();
		for(LetterCount lc : hm.values()){
			if(list.size() < 10){
				list.add(lc);
			}
			else{
				Collections.sort(list, new Comparator<LetterCount>(){
					@Override
					public int compare(LetterCount l1, LetterCount l2){
						return l1.count - l2.count;
					}
				});
				if(list.get(0).count < lc.count){
					list.remove(0);
					list.add(lc);
				}
			}
		}
		
		Collections.sort(list, new Comparator<LetterCount>(){
			@Override
			public int compare(LetterCount l1, LetterCount l2){
				return l1.ch - l2.ch;
			}
		});

		for(LetterCount lc : list){
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
/*
	A=394
	D=238
	E=731
	I=364
	L=281
	N=383
	O=384
	R=399
	S=352
	T=425
*/
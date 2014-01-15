import java.util.*;
import java.lang.*;

class Solution{
	public String toShortURL(long id, int base, HashMap<Integer, Character> map){
		StringBuilder sb = new StringBuilder();
		while(id > 0){
			int digit = (int)id % base;
			System.out.println(digit);
			sb.append(map.get(digit));
			id /= base;
		}
		/*
		while(sb.length() < 6){
			sb.append('0');
		}
		*/
		return sb.reverse().toString();
	}

	public long toID(String shortUrl, int base, HashMap<Character, Integer> map){
		StringBuilder sb = new StringBuilder(shortUrl);
		long id = 0L;
		for(int i = 0; i < sb.length(); i ++){
			System.out.println(map.get(sb.charAt(i)) + " " + (sb.length() - 1 - i));
			id += map.get(sb.charAt(i)) * Math.pow(base, sb.length() - 1 - i);
		}

		return id;
	}
}

class ConversionMap{
	private HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
	private HashMap<Character, Integer> hm_back = new HashMap<Character, Integer>();

	public ConversionMap(){
		int index = 0;
		for(int i = '0'; i <= 'z'; i ++){
			if(Character.isDigit(i) ||    // Character.isAlphabetic(i) only exist in Java 7
					(i >= 'A' && i <= 'Z') ||
					(i >= 'a' && i <= 'z') ){  
				hm.put(index, (char)i);
				hm_back.put((char)i, index);
				index ++;
			}
		}
	}

	public HashMap getConversionMap(){
		return hm;
	}

	public HashMap getReversionMap(){
		return hm_back;
	}
}
public class TinyURL{
	public static void main(String[] args){ 
		// Long.MAX_VALUE  = 2^64 - 1
		ConversionMap map = new ConversionMap();
		Solution s = new Solution();

		System.out.println(s.toShortURL(10009999L, 62, map.getConversionMap()));
		/*
			在定义数字常量的时候， 默认的都是INT型，LONG开的要这样定义

			long l = 78541258611L;  <-   在最后加上'L'
		*/
		System.out.println(s.toID("g03b", 62, map.getReversionMap()));
	}
}





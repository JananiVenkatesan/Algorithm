/*

Question:

	Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?



Solution:

	Given this, one simple optimization we can make to this problem is to 
automatically return false if the length of the string is greater than the number 
of unique characters in the alphabet. After all, you can't have a string with 280 
unique characters if there are only 256 possible unique characters.

*/


public class C1Q1{
	public static void main(String[] args){
		String[] words = new String[]{"abcde", "hello", "apple", "kite", "padle"};

		for(String word:words){
			System.out.println(word+" :  "+isUniqueChars(word));
		}
	}

	public static boolean isUniqueChars(String str){
		if(str.length()>256)
			return false;

		boolean[] charset = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i); // get the ASCII number value of that char
			if(charset[val])
				return false;

			charset[val] = true;
		}

		return true;
	}
}

/*
Problem:
	Write a method to compute all permutations of a string

Solution:
	page 324

	This solution takes 0(n!) time, since there are n! permutations.
We cannot do better than this.
*/

public static ArrayList<String> getPerms(String str){
	if(str == null){  // special case
		return null;
	}
	ArrayList<String> permutations = new ArrayList<String>();
	if(str.length() == 0){  // base case
		permutations.add("");
		return permutations;
	}
	char first = str.char(0);  // get the first character
	String remainder = str.substring(1);  // remove the 1st character
	ArrayList<String> words = getPerms(remainder);
	for(String word : words){
		for(int i = 0; i <= word.length(); i++){
			String s = insertCharAt(word, first, i);
			permutations.add(s);
		}
	}
	return permutations;
}

public static String insertCharAt(String word, char ch, int index){
	String first = word.substring(0, index);
	String second = word.substring(index);
	return first + ch + second;
}








/*

Problem:

    Given two strings, write a method to decide if one is a permutation of the other


Solution:

    Like in many questions, we should confirm some details with our interviewer. 

    1. We should understand if the anagram comparison is case sensitive.
    That is, is God an anagram of dog? 

    2. Additionally, we should ask if whitespace is significant.
    We will assume for this problem that the comparison is case sensitive and whitespace 
    is significant. So, "god     " is different from "dog".

    3. Whenever we compare two strings, we know that if they are different lengths then 
    they cannot be anagrams!!!!!!


    There are two easy ways to solve this problem, both of which use this optimization.



Solution #1: Sort the strings.

    If two strings are anagrams, then we know they have the same characters, 
but in different orders. Therefore, sorting the strings will put the characters 
from two anagrams in the same order. We just need to compare the sorted versions
of the strings.

*/

    public boolean permutation(String s1, String s2){
    	// delete additional whitespace
        s1 = s1.trim();
        s2 = s2.trim();

        // if the lengths of them are different, under no circumstances they are going to be permutated
        if(s1.length() != s2.length())
    		return false;

    	return sortChar(s1).equals(sortChar(s2));
    }

    public String sortChar(String str){
    	char[] charArray = str.toCharArray();
    	Arrays.sort(charArray);
    	
    	/*
        we cannot use  
    	  return charArray.toString();  

    	since charArray is an array, charArray.toString() returns the memory address of charArray[0]
    	use .toString() method in this kind of case

    	  StringBuilder sb = new StringBuilder;
    	  sb.toString();
		*/
    	  
    	return new String(charArray);
    }


/*

Solution #2: Check if the two strings have identical character counts.
    
    We can also use the definition of an anagram—two words with the same 
character counts—to implement this algorithm. We simply iterate through 
this code, counting how many times each character appears.Then, afterwards, 
we compare the two arrays.

*/

public boolean permutation(String s1, String s2){
    if(s1.length() != s2.length())
        return false;

    int[] ascii = new int[256];
    char[] chars = s1.toCharArray();
    
    for(char c : chars){
        ascii[c]++;
    }

    for(int i = 0; i < s2.length(); i++){
        int c = (int)s2.charAt(i);
        ascii[c] --;
        if(ascii[c] < 0)
            return false;
    }
    return true;
}















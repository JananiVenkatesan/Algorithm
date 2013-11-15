/*

Problem:

       Write a method to replace all spaces in a string with '%20'. You may assume that the 
    string has sufficient space at the end of the string to hold the additional characters, 
    and that you are given the "true" length of the string. (Note: if implementing in Java, 
    please use a character array so that you can perform this operation in place.)



Solution:

       A common approach in string manipulation problems is to edit the string starting from 
    the end and work backwards. This is useful because we have extra buffer at the end, which
    allows us to change characters without worrying about what we're overwriting.

       We will use this approach in this problem. The algorithm works through a two scan approach. 
    In the first scan, we count how many spaces there are in the string. This is used to compute 
    how long the final string should be. In the second pass, which is done in reverse order, we 
    actually edit the string. When we see a space, we copy %20 into the next spots. If there is 
    no space, then we copy the original character.
*/

	public String replacesSpaces(char[] charArray, int length){
		if(charArray == null)
			return null;
		
		int countSpaces = 0;
		int newLength;

		for(int i=0; i<length; i++)
			if(charArray[i]==' ')
				countSpaces++;

		newLength = length + countSpaces*2;  // calculate the new length of the whole array

		charArray[newLength]='\0';  // mark the end of the new array 

		for(int i=length-1; i>=0; i--){
			if(charArray[i]==' '){  // replace space with '%20' element by element
				charArray[newLength-1] = '0';
				charArray[newLength-2] = '2';
				charArray[newLength-3] = '%';
				newLength = newLength-3;
			}else{
				charArray[newLength-1] = charArray[i];
				newLength--;
			}
		}

		return new String(charArray);
	}

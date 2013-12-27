/*
Problem:
       Write a method to replace all spaces in a string with '%20'. You
may assume that the string has sufficient space at the end of the string 
to hold the additional characters, and that you are given the "true" 
length of the string. (Note: if implementing in Java, please use a 
character array so that you can perform this operation in place.)

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

public String replaceSpace(char[] array, int length){
	if(array == null || length < 0)
		return null;
	
	int count = 0;
	for(int i = 0; i < length; i ++){
		if(array[i] == ' ')
			count ++;
	}

	int newLength = length + 2 * count;
	array[newLength] = '\0';
	int cur = newLength - 1;
	for(int i = length - 1; i >= 0; i --){
		if(array[i] != ' '){
			array[cur] = array[i];
			cur --;
		}
		else{
			array[cur] = '0';
			array[cur - 1] = '2';
			array[cur - 2] = '%';
			cur = cur - 3;
		}
	}
	return new String(array);
}

/*

Problem:

	Given a positive integer, print the next smallest and the next 
largest number that have the same number of 7 bits in their binary 
representation.




Solution:

Bit Manipulation Approach for Get Next Number

	A relatively easy way of doing this is to count how many 
ones are to the right of p, clear all the bits from 0 until p, and
then add back in (c1 - 1) ones. Let c1 be the number of ones to the 
right of p and c0 be the number of zeros to the right of p.

	page 245

*/

public int getNext(int n){
	/* 
		n = 11 0110 0111 1100
	Compute c0 and c1 */
	int c = n;
	int c0 = 0;
	int c1 = 0;
	// Count the number of zeros to the right of p 
	while( ((c & 1) == 0) && (c != 0) ){ // c & 00 000 0000 0001
		c0 ++;
		c = c >> 1;
	}

	// Count the number of ones to the right of p
	while( (c & 1) == 1){
		c1 ++;
		c = c >> 1;
	}

	/* Error: if n == 11..1100...00, then there is no bigger 
	number with the same number of 1s. */
	if(c0 + c1 == 31 || c0 + c1 == 0){
		return -1;
	}

	int p = c0 + c1;  // position of rightmost non-trailing zero, p = 7

	/*
		Flip rightmost non-trailing zero  
		11 0110 0111 1100 | 00 0000 1000 0000 = 11 0110 1111 1100
	*/
	n = n | (1 << p); 

	/*
		Clear all bits to the right of p
		11 0110 1111 1100 | 11 1111 1000 0000 = 11 0110 1000 0000
	*/
	n = n & ~((1 << p) - 1);

	/*
	    Insert (c1-1) ones on the right.
	    c1 - 1 = 5
	    1 << (c1 - 1) 	 = 00 0000 0001 0000
	    1 << (c1 - 1) -1 = 00 0000 0000 1111

	    11 0110 1000 0000 | 00 0000 0000 1111 = 11 0110 1000 1111
	*/
	n = n | (1 << (c1 - 1)) - 1;
	return n;
}

/*
	
Bit Manipulation Approach for Get Previous Number

	1. Compute c0 and c1. Note that c1 is the number of trailing ones, 
and c0 is the size of the block of zeros immediately to the left of the 
trailing ones.

	2. Flip the right most non-trailing one to a zero.This will be at 
position p = c1 + c0.

	3. Clear all bits to the right of bit p.

	4. Insert (c1 + 1) ones immediately to the right of position p.

	page 247
*/


public int getPrev(int n){
	int c = n;
	int c0 = 0;
	int c1 = 1;

	while( c & 1 == 1){
		c1 ++;
		c = c >> 1;
	}
	if(c == 0)
		return -1;

	while( ((c & 1) == 0) && (c != 0) ){
		c0 ++;
		c = c >> 1;
	}

	int p = c0 + c1;  // position of rightmost non-trailing one
	n &= (~0) << (p + 1)  // clears from bit p onwards
	
	int mask = (1 << (c1 + 1)) - 1;  // Sequence of (cl+1) ones
	n |= mask << (c0 - 1);

	return n; 
}

/*

Arithmetic Approach to Get Next Number

	1. Set the pth bit to1
	2. Set all bits following p to 0
	3. Set bits 0 through (c1 - 1) to 1.
	A quick and dirty way to perform steps 1 and 2 is to set the 
trailing zeros to 1 (giving us p trailing ones),and then add 1. 
Adding one will flip all trailing ones,sowe wind up with a 1 at 
bit p followed by p zeros. We can perform this arithmetically.

*/

int getNextArith(int n){
	int c = n;
	int c0 = 0;
	int c1 = 0;

	while( ((c & 1) == 0) && (c != 0) ){ // c & 00 000 0000 0001
		c0 ++;
		c = c >> 1;
	}
	while( (c & 1) == 1){
		c1 ++;
		c = c >> 1;
	}
	if(c0 + c1 == 31 || c0 + c1 == 0){
		return -1;
	}

	int p = c0 + c1; 
	return n + (1 << c0) + (1 << (c1 - 1)) - 1;
}

/*

Arithmetic Approachto Get Previous Number

*/

public int getPrev(int n){
	int c = n;
	int c0 = 0;
	int c1 = 1;

	while( c & 1 == 1){
		c1 ++;
		c = c >> 1;
	}
	if(c == 0)
		return -1;

	while( ((c & 1) == 0) && (c != 0) ){
		c0 ++;
		c = c >> 1;
	}

	int p = c0 + c1; 

	return n - (1 << c1) - (1 << (c0-1)) + 1;
}


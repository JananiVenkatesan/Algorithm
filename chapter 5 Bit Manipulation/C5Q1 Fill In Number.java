/*
Problem:
	You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
Write a method to insert M into N such that M starts at bit j and ends at bit i. 
You can assume that the bits j through i have enough space to fit all of M. That 
is, if M= 10011, you can assume that there are at least 5 bits between j and i.
You would not, for example, have j = 3 and i = 2, because M could not fully fit 
between bit 3 and bit 2.

	EXAMPLE:

	Input: N = 100 0000 0000, M = 10011, i = 2, j = 6   
	Output: N = 100 0100 1100
*/

public int updateBits(int n, int m, int i, int j){
	/* 
		Create a mask to clear bits i through j in n
		EXAMPLE: i = 2, j = 4. 
		N = 0010 1110   M = 101
		Result should be 0011 0110.
		For simplicity, we'll use just 8 bits for the example.
	*/

	int allOnes = ~0;  // will equal sequence of all 1s, 11111111
	int left = allOnes << (j + 1);  // 1s before position j, then 0s. left = 1110 0000
	/* 
	    1's after position i. right = 0000 0011
	
		(1 << i) = 0000 0100
		00000100 - 1 = 0000 0100 - 0000 0001 = 0000 0011
	*/
	int right = (1 << i) - 1;

	// All 1s, except for 0s between i and j.  1110 0000 | 0000 0011 = 1110 0011
	int mask = left | right;

	/* Clear bits j through i then put m in there */
	n = n & mask;  // Clear bits j through i. 0010 1110 | 1110 0011 = 0010 0010
	m = m << i;    // Move m into correct position. 101 << 2 = 1 0100

	return n | m;  // OR them 0010 0010 | 1 0100 = 0011 0110
}










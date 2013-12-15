/*
Problem:
	Write a program to swap odd and even bits in an integer 
with as few instructions as possible (e.g., bit 0 and bit 1 are 
swapped, bit 2 and bit 3 are swapped, and soon).

Solution:

	We can mask all odd bits with 10101010 in binary (which is 
0xAA), then shift them right by 1 to put them in the even spots. 
For the even bits, we do an equivalent operation. Finally, we 
merge these two values.
*/


public int swapOddEvenBits(int x){
	return ( ((x & 0xAAAAAAAA) >> 1) | ((x & 0X55555555) << 1) )
}






/*

Problem:

	To approach this, ask yourself how you would figure out 
which bits in two numbers are different. 
	Simple: with an XOR.


Solution:

	Each 1 in the XOR represents a bit that is different 
between A and B. Therefore, to check the number of bits that 
are different between A and B, we simply need to count the 
number of bits in AAB that are 1.

*/

int bitSwapRequired(int a, int b){
	int count = 0;
	for(int c = a ^ b; c != 0; c >> = 1){
		count + = (c & 1);
	}
	return count;
}
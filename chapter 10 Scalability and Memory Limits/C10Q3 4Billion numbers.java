/*
Problem:
	Given an input file with four billion non-negative integers, 
provide an algorithm to generate an integer which is not contained 
in the file. Assume you have 1 GB of memory availablefor this task.

Solution:
	since int is 32 bits, its range is from (2^-31) ~ (2^31 - 1)
So there will be only (2^31 - 1) unique integers in the four billion
integers.

*/

long numberOfInts = ((long)Integer.MAX_VALUE) + 1;  // (2^31 - 1) + 1 = 2^31
byte[] bitfield = new byte[(int)(numberOfInts / 8)];

public void findOpenNumber(){
	try{
		Scanner in = new Scanner(new FileReader("file.txt");
		while(in.hasNextInt()){
			int n = in.nextInt();
			/* Finds the corresponding number in the b itfie ld by using
			 * the OR operator to set the nth bit of a byte
			 * (e.g., 10 would correspond to the 2nd bit of index 2 in 
			 * the byte array). 
			 */
			 bitfield[n / 8] = bitfield[n / 8] | 1 << (n % 8);
		}

		for(int i = 0; i < bitfield.length; i ++){
			for(int j = 0; j < 8; j ++){
				/* Retrieves the individual bits of each byte. When 0 bit 
				* is found, finds the corresponding value. */
				if((bitfield[i] & (1 << j)) == 0){
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}
	catch(Exception e){
	}
}

/*
FOLLOW UP
	What if you have only 10 M8 of memory? Assume that all the 
values are distinct and we now have no more than one billion 
non-negative integers.
*/

int bitsize = 1048576;  // 2^20 bits (2^17 bytes)
int blockNum = 4096;    // 2^12
byte[] bitfield = new byte[bitsize / 8];
int[] blocks = new int[blockNum];

public void findOpenNumber() throws FileNotFoundException{
	int starting = - 1;
	Scanner in = new Scanner(new FileReader("file.txt"));
	while(in.hasNextInt()){
		int n = in.nextInt();
		blocks[n / (bitfield.length * 8)] ++;
	}

	for(int i = 0; i < blocks.length; i ++){
		if(blocks[i] < bitfield.length * 8){
			/* if value < 2^20, then at least 1 number is missing 
			 * in that section. */
			starting = i * bitfield.length * 8;
			break;
		}
	}

	in = new Scanner(new FileReader("file.txt"));
	while(in.hasNextInt()){
		int n = in.nextInt();
		/* If the number is inside the block that's missing
		 * numbers, we record it */
		if(n >= starting && n < starting + bitfield.length * 8){
			bitfield[(n - starting) / 8] |= 1 <<((n - starting) % 8);
		}
	}

	for(int i = 0; i < bitfield.length; i ++){
		for(int j = 0; j < 8; j ++){
			/* Retrieves the individual bits of each byte. When 0 bit 
			 * is found, finds the corresponding value. */
			if((bitfield[i] & (1 << j)) == 0){
				System.out.println(i * 8 + j + starting);
				return;
			}
		}
	}
}















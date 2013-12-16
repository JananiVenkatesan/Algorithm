/*
Problem:
	You have an array with all the numbers from 1 to N, where 
N is at most 32,000. The array may have duplicate entries and 
you do not know what N is. With only 4 kilo-bytes of memory
available, how would you print all duplicate elements in the 
array?

Solution:
	4 kilobytes = 4 * 1024 bytes = 4 * 8 * 1024 bits > 32000
*/


public void checkDuplicates(int[] array){
	BitSet bs = new BitSet(32000);
	for(int i = 0; i < array.length; i ++){
		int num = array[i];
		int num0 = num - 1;  // bitset starts at 0, numbers start at 1
		if(bs.get(num0)){
			System.out.println(num);
		}
		else{
			bs.set(num0);
		}
	}

}

class BitSet{
	int[] bitset;

	public BitSet(int size){
		bitset = new int[size >> 5];  // divide by 32, 1 int = 32 bits
	}

	public boolean get(int pos){
		int wordNumber = (pos >> 5);  //divide by 32
		int bitNumber = (pos & 0x1F);  // mod 32
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}

	public void set(int pos){
		int wordNumber = (pos >> 5);  //divide by 32
		int bitNumber = (pos & 0x1F);  // mode 32
		bitset[wordNumber] |= 1 << bitNumber;
	}

}













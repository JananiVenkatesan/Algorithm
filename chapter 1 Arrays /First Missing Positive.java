/*
	Given an unsorted integer array, find the first missing positive integer.

	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.

	Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] A){
    		int i = 0;
    		int[] B = new int[A.length];
    		while(i < A.length){
    			if(A[i] > 0 && A[i] <= A.length){
    				B[A[i] - 1] = A[i];
    			}
    			i ++;	
    		}
    		i = 0;
    		while(i < B.length && B[i] == i + 1)
    			i ++;
    		return i + 1;
  	}
}

A[0] A[1] A[2] A[3]
  4    3    -1   1 

B[0] B[1] B[2] B[3]
  1    0    3    4
       ^
       |    

public int firstMissingPositive(int[] A) {  
    // in-place swap (bucket sort)  
    int i = 0;  
    while (i < A.length) {  
     	if (A[i] > 0 && A[i] <= A.length && A[i] != i+1 && A[i] != A[A[i]-1]) {  
        	int temp = A[A[i]-1];  
        	A[A[i]-1] = A[i];  
        	A[i] = temp;  
    	} 
    	else {  
       		i ++;  
     	}  
    }  
    // find the first positive missing integer  
    i = 0;  
    while (i < A.length && A[i] == i+1) 
    	i ++;  
   	return i+1;  
}

public int firstMissingPositive(int[] A) {  
    // in-place swap (bucket sort)  
    for (int i=0; i<A.length; ++i) {  
        while (A[i] > 0 && A[i] <= A.length && A[i] != i+1 && A[i] != A[A[i]-1]) {  
        	int temp = A[A[i]-1];  
        	A[A[i]-1] = A[i];  
        	A[i] = temp;  
    	}  
    }  
   	// find the first positive missing integer  
    int index = 0;  
    while (index < A.length && A[index] == index+1) 
    	index ++;  
    return index + 1;  
}    
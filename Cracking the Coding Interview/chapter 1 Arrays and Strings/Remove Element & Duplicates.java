/*

Problem:
	Given an array and a value, remove all instances of that 
value in place and return the new length.


Solution:
	The order of elements can be changed. It doesn't matter 
what you leave beyond the new length.

*/


public class Solution{
	public int removeElement(int[] A, int elem){
		if(A == null)
			return -1;
		int count = 0;
		for(int i = 0; i < A.length; i ++){
			if(A[i] == elem){
				count ++;
			}
			else{
				A[i - count] = A[i];
			}
		}
		return A.length - count;
	}
}

/*
Problem:
	Given a sorted array, remove the duplicates in place such 
that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.

	For example,
		Given input array A = [1,1,2],

	Your function should return length = 2, and A is now [1,2].

*/

public class Solution {
    public int removeDuplicates(int[] A){
        if(A == null)
            return -1;
        // Record total number of repulicates
        int count = 0;
        for(int i = 1; i < A.length; i ++){
            // Get the previous element and compare
            int current = A[i - 1];
            if(A[i] == current){
                count ++;
            }else{
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}
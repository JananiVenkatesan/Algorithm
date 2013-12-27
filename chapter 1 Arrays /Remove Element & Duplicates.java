/*
Remove Element
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
Remove Duplicates from Sorted Array
*/

public class Solution {
    public int removeDuplicates(int[] A){
        if(A == null)
            return -1;
        // Record total number of repulicates
        int count = 0;
        for(int i = 1; i < A.length; i ++){
            // Get the previous element and compare
            if(A[i] == A[i - 1]){
                count ++;
            }else{
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}


/*

Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?

	For example,
		Given sorted array A = [1,1,1,2,2,3],

	Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A){
        if(A == null)
            return -1;
        int count = 0;
        for(int i = 2; i < A.length; i ++){
            // IMPORTANT! 判断与最开头的两个相同数是否一样
            if(A[i]  == A[i - count - 1] && A[i] == A[i - count - 2]){
                count ++;
            }else{
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}




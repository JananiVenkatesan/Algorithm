/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public int search(int[] A, int x){
    if(A == null || A.length == 0)
        return -1;
    int left = 0, right = A.length - 1;
    while(left <= right){
        int mid = left + (right - left) / 2;
        if(A[mid] == x)
            return mid;
        if(A[left] <= A[mid]){
            if(A[left] <= x && x < A[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        else{
            if(A[mid] < x && x <= A[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    return -1;
}

// Follow up: with duplicates


public int search(int[] A, int target) {
    if(A == null || A.length == 0)
        return -1;
    return search(A, 0, A.length - 1, target);
}
    
public int search(int[] A, int left, int right, int target){
    int mid = (left + right) / 2;
    if(x == A[mid])
    	return mid;
    if(left > right)
    	return -1;

    /* Either the left or right half must be normally ordered. 
    * Find out which side is normally ordered, and then use the 
    * normally ordered half to figure out which side to search 
    * to find x. 
    */

    if(A[left] < A[mid]){  // Left is normally ordered.
    	if(A[left] <= x && x <= A[mid])
    		return search(A, left, mid - 1, x);
    	else
    		return search(A, mid + 1, right, x);
    }
    else if(A[mid] < A[left]){  // Right is normally ordered
    	if(A[mid] <= x && x <= A[right])
    		return search(A, mid + 1, right, x);
    	else
    		return search(A, left, mid - 1, x);
    }
    else if(A[left] == A[mid]){  // Left half is all repeats
    	if(A[mid] != A[right]){  // If right is diff., search it
    		return search(A, mid + 1, right, x);
    	}
    	else{  // Else we have to search both halves
    		int result = search(A, left, mid - 1, x);
    		if(result == -1){
    			return search(A, mid + 1, right, x);
    		}
    		else{
    			return result;
    		}
    	}
    }
    return -1;
}









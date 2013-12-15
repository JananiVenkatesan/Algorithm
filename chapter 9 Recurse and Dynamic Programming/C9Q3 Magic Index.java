/*
Problem:
	A magic index in an array A[l...n-l] is defined to be an 
index such that A[i] = i. Given a sorted array of distinct 
integers, write a method to find a magic index, if one exists, 
in array A.

Solution:
	page 320 
*/

public int magicFast(int[] A){
	if(A == null || A.length == 0)
		return -1;
	return magicFast(A, 0, A.length - 1);
}

public int magicFast(int[] A, int left, int right){
	if(left > right || left < 0 || right >= A.length){
		return -1;
	}

	int mid = left + (right - left) / 2;
	if(A[mid] == mid){
		return mid;
	}
	else if(A[mid] > mid){
		return magicFast(A, left, mid - 1);
	}
	else{
		return magicFast(A, mid + 1, right);
	}
}


/*
FOLLOW UP
	What if the values are not distinct?

Solution:
	page 320 
*/

public int magicFast(int[] A){
	if(A == null || A.length == 0)
		return -1;
	return magicFast(A, 0, A.length - 1);
}

public int magicFast(int[] A, int left, int right){
	if(left < 0 || left > right || right >= A.length){
		return -1;
	}

	int midIndex = left + (right - left) / 2;
	int midValue = A[midIndex];
	if(midIndex == midValue){
		return midIndex;
	}

	int leftIndex = Math.min(minIndex - 1, midValue);
	int leftValue = magicFast(A, left, leftIndex);
	if(leftValue > 0){
		return leftValue;
	}

	int rightIndex = Math.max(midIndex + 1, minValue);
	int rightValue = magicFast(A, rightIndex, right);
	return rightValue;
}
























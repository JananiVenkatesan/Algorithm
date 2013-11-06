/*
Problem:
	A magic index in an array A[l...n-l] is defined to be an index such
that A[i] = i. Given a sorted array of distinct integers, write a method to 
find a magic index, if one exists, in array A.

Solution:
	page 320 
*/

public static int magicFast(int[] array, int start, int end){
	if(end < start || start < 0 || end >= array.length){
		return -1;
	}
	int mid = (start + end) / 2;
	if(array[mid] == mid){
		return mid;
	}else if(array[mid] > mid){
		return magicFast(array, start, mid - 1);
	}else{
		return magicFast(array, mid + 1, end);
	}
}

public static int magicFast(int[] array){
	magicFast(array, 0, array.length - 1);
}

/*
FOLLOW UP
	What if the values are not distinct?

Solution:
	page 320 
*/

public static int magicFast(int[] array, int start, int end){
	if(end < start || start < 0 || end > array.length - 1){
		return -1;
	}
	int midIndex = (start + end) / 2;
	int midValue = array[midIndex];
	if(midIndex == midValue){
		return midIndex;
	}

	/* Search left */
	int leftIndex = Math.min(midIndex - 1, midValue);
	int left = magicFast(array, start, leftIndex);
	if(left >= 0){
		return left;
	}

	/* Search right */
	int rightIndex = Math.max(midIndex + 1, midValue);
	int right = magicFast(array, rightIndex, end);
	return right;
}

public static int magicFast(int[] array){
	return magicFast(array, 0, array.length - 1);
}






















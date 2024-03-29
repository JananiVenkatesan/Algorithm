/*
There are two sorted arrays A and B of size m and n respectively. 

Find the median of the two sorted arrays. 

The overall run time complexity should be O(log (m+n)).

http://www.youtube.com/watch?v=_H50Ir-Tves
*/

public double findMedianSortedArrays(int[] A, int[] B){
	  int m = A.length, n = B.length, mid = (m + n) / 2;
	  if( m < n){
    	  return findMedian(A, B, 0, m - 1);
   	}
   	else{
   		  return findMedian(B, A, 0, n - 1);
   	}
}



private double findMedian(int[] A, int[] B, int left, int right){
  	int m = A.length, n = B.length, mid = (m + n) / 2;
  	if(left > right){
  		return findMedian(B, A, Math.max(0, mid - m), Math.min(n - 1, mid));
  	}

  	int i = (left + right) / 2, j = mid - i - 1;
  	if(j >= 0 && A[i] < B[j])  // A[i] < median
  		return findMedian(A, B, i + 1, right);
  	if(j < n - 1 && A[i] > B[j + 1])  // A[i] > median
  		return findMedian(A, B, left, i - 1);

  	// found median (j<0 => mid-i-1 < 0 => i=mid; j>=n-1 => mid-i-1>=n-1 => i=mid-n) 
    // m+n is odd
    if( ((m + n) % 2 == 1) || (i <= 0 && (j < 0 || j >= n)))
    	return A[i];
    // m+n is even
    if(j < 0 || j >= n)
    	return (A[i] + A[i - 1]) / 2.0;
    if(i <= 0)
    	return (A[i] + B[j]) / 2.0;
    return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
}







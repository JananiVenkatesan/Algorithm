/*
    Given two sorted integer arrays A and B, merge B into A as 
    one sorted array.

    Note:
    You may assume that A has enough space to hold additional elements 
    from B. The number of elements initialized in A and B are m and n 
    respectively.

*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(B == null || n == 0){
            return;
        }
        int i = m + n - 1;
        m --;
        n --;
        while(m >= 0 && n >= 0){
            if(A[m] > B[n]){
                A[i] = A[m];
                m--;
            }
            else{
                A[i] = B[n];
                n --;
            }
            i --;
        }
        while(n >= 0){
            A[i] = B[n];
            i --;
            n --;
        }
    }
}
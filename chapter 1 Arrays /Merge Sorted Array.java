// Given two sorted integer arrays A and B, merge B into A as one sorted array.

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